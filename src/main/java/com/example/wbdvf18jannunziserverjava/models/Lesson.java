package com.example.wbdvf18jannunziserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

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
    ArrayList<Topic> topicMany;

    public Lesson(Integer id, String title, ArrayList<Topic> topics) {
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

    public ArrayList<Topic> getTopics() {
        return topicMany;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topicMany = topics;
    }

}
