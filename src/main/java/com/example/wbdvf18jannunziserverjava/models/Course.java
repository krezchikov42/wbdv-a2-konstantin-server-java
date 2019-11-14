package com.example.wbdvf18jannunziserverjava.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    Integer id;
    @OneToMany(mappedBy = "course")
    List<Module> moduleMany;
    String title;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public  Course(Integer id, String title) {
        this.id = id;
        this.moduleMany = new ArrayList<>();
        this.title = title;
    }

    public Course(Integer id, List<Module> moduleMany, String title) {
        this.id = id;
        this.moduleMany = moduleMany;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
