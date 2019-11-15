package com.example.wbdvf18jannunziserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @ManyToOne
    @JsonIgnore
    private Module module;

    @OneToMany(mappedBy = "lesson")
    private List<Topic> topicMany;

    public Lesson(){

    }

    public Lesson(Integer id, String title, List<Topic> topics) {
        this.id = id;
        this.title = title;
        this.topicMany = topics;
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

    public List<Topic> getTopics() {
        return topicMany;
    }

    public void setTopics(List<Topic> topics) {
        this.topicMany = topics;
    }

}
