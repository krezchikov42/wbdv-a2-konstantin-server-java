package com.example.wbdvf18jannunziserverjava.models;

import java.util.ArrayList;
import java.util.List;

public class Module {
    Integer id;
    List<Topic> topicMany;
    String title;


    public Module() {
    }

    public Module(Integer id) {
        this.id = id;
    }

    public Module(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.topicMany = new ArrayList<>();
    }

    public Module(Integer id, List<Topic> topicMany, String title) {
        this.id = id;
        this.topicMany = topicMany;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }


    public List<Topic> getTopicMany() {
        return topicMany;
    }

    public void setTopicMany(List<Topic> topicMany) {
        this.topicMany = topicMany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
