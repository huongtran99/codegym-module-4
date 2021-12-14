package com.codegym.service.type;

import com.codegym.model.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeService implements ITypeService {

    private List<Type> types = new ArrayList<>();

    @Override
    public List<Type> findAll() {
        return types;
    }

    @Override
    public void save(Type type) {
        types.add(type);
    }

    @Override
    public Type findById(int id) {
        return types.get(id);
    }

    @Override
    public void update(int id, Type type) {
        for (Type t : types) {
            if (t.getId() == id) {
                t = type;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).getId() == id) {
                types.remove(i);
                break;
            }
        }
    }

    @Override
    public int findByIndex(int id) {
        int index = -1;
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
