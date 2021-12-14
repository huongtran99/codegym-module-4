package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Image;
import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.ICategoryService;
import com.codegym.service.IImageService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IProductService productService;

    @Autowired
    private IImageService imageService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Page<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @ModelAttribute("image")
    public Page<Image> images(Pageable pageable) {
        return imageService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showListProduct(@RequestParam("search") Optional<String> search, @PageableDefault(size = 10) Pageable pageable) {
        Page<Product> products;
        if (search.isPresent()) {
            products = productService.findAllByProductNameContaining(search.get(), pageable);
        } else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("product", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@Validated @ModelAttribute("product") ProductForm productForm,
                                    BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/product/create");
        }
        Product product = new Product();
        product.setProductName(productForm.getProductName());
        product.setPrice(productForm.getPrice());
        product.setDescription(productForm.getDescription());
        product.setCategory(productForm.getCategory());
        productService.save(product);

        List<MultipartFile> multipartFiles = productForm.getImages();
        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new Image();
            image.setName(fileName);
            image.setProduct(product);
            imageService.save(image);
        }
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", productForm);
        modelAndView.addObject("message", "New Product created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        ModelAndView modelAndView;
        if (product.isPresent()) {
            modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
        } else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute(name = "product") ProductForm productForm) {
        Product product = new Product();
        product.setProductId(productForm.getProductId());
        product.setProductName(productForm.getProductName());
        product.setPrice(productForm.getPrice());
        product.setDescription(productForm.getDescription());
        product.setCategory(productForm.getCategory());
        productService.save(product);

/*        List<MultipartFile> multipartFiles = productForm.getImages();
        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new Image();
            image.setName(fileName);
            image.setProduct(product);
            imageService.save(image);
        }*/
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "successfully");
        return modelAndView;
    }

}
