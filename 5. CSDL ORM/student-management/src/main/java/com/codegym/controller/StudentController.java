package com.codegym.controller;


import com.codegym.model.Student;
import com.codegym.model.StudentForm;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping
    public ModelAndView showAll(@RequestParam(name = "q", required = false) String name) {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        List<Student> students;
        if (name == null) {
            students = studentService.findAll();
        } else {
            students = studentService.findByName(name);
        }
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new StudentForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createProduct(@ModelAttribute StudentForm studentForm) {
        MultipartFile multipartFile = studentForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(studentForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student student = new Student();
        student.setId(studentForm.getId());
        student.setName(studentForm.getName());
        student.setAddress(studentForm.getAddress());
        student.setEmail(studentForm.getEmail());
        student.setImage(fileName);
        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("s", studentService.findById(id));
        return "student/delete";
    }

    @PostMapping("/delete")
    public String delete(Student student, RedirectAttributes redirect) {
        studentService.delete(student.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/edit";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/view";
    }

}
