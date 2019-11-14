package com.example.wbdvf18jannunziserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @ManyToOne
    @JsonIgnore
    private Lesson lesson;

    @OneToMany(mappedBy = "topic")
    private List<Widget> widgetMany;

    public Topic(Integer id) {
        this.id = id;
    }

    public Topic(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Topic(Integer id, List<Widget> widgetMany, String title) {
        this.id = id;
        this.widgetMany = widgetMany;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public List<Widget> getWidgetMany() {
        return widgetMany;
    }

    public void setWidgetMany(List<Widget> widgetMany) {
        this.widgetMany = widgetMany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
