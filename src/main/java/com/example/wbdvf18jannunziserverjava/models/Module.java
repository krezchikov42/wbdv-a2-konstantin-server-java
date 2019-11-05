package com.example.wbdvf18jannunziserverjava.models;

import java.util.ArrayList;
import java.util.List;

public class Module {
    Integer id;
    List<Lesson> lessons;
    String title;


    public Module() {
    }

    public Module(Integer id) {
        this.id = id;
    }


    public Module(Integer id, List<Lesson> lessons, String title) {
        this.id = id;
        this.lessons = lessons;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
