package com.example.wbdvf18jannunziserverjava.models;

import java.util.List;

public class Course {
    Integer id;
    List<Module> module_many:

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, List<Module> module_many) {
        this.id = id;
        this.module_many = module_many;
    }

    public Integer getId() {
        return id;
    }

    public List<Module> getModule_many() {
        return module_many;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModule_many(List<Module> module_many) {
        this.module_many = module_many;
    }
}
