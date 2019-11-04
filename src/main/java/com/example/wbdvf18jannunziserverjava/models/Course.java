package com.example.wbdvf18jannunziserverjava.models;

import java.util.List;

public class Course {
    Integer id;
    List<Module> moduleMany;
    String title;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, List<Module> moduleMany, String title) {
        this.id = id;
        this.moduleMany = moduleMany;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Module> getModuleMany() {
        return moduleMany;
    }

    public void setModuleMany(List<Module> moduleMany) {
        this.moduleMany = moduleMany;
    }
}
