package com.example.wbdvf18jannunziserverjava.models;

import java.util.ArrayList;

public class Lesson {
    Integer id;
    String title;
    ArrayList<Topic> topics;

    public Lesson(Integer id, String title, ArrayList<Topic> topics) {
        this.id = id;
        this.title = title;
        this.topics = topics;
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

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }
}
