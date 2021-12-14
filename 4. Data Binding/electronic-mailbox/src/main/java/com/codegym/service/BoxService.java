package com.codegym.service;

import com.codegym.model.Box;

import java.util.ArrayList;
import java.util.List;

public class BoxService {
    private static final List<Box> boxes = new ArrayList<>();

    static {
        boxes.add(new Box(1, "English", 25, false, "King"));
    }

    public List<Box> findAll() {
        return boxes;
    }

    public void save(Box box) {
        boxes.add(box);
    }

    public Box findById(int id) {
        for (Box box : boxes) {
            if (box.getId() == id) {
                return box;
            }
        }
        return null;
    }

    public void update(int id, Box box) {
        for (Box b : boxes) {
            if (b.getId() == id) {
                b = box;
                break;
            }
        }
    }

    public int findByIndex(int id) {
        int index = -1;
        for (int i = 0; i < boxes.size(); i++) {
            if (id == boxes.get(i).getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void remove(int id) {
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).getId() == id) {
                boxes.remove(i);
                break;
            }
        }
    }

}
