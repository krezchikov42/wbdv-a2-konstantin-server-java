package com.example.wbdvf18jannunziserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToMany(mappedBy = "module")
    List<Lesson> lessonMany;

    String title;
    @ManyToOne
    @JsonIgnore
    private Course course;

    public Module() {
    }

    public Module(Integer id) {
        this.id = id;
    }

    public Module(Integer id, List<Lesson> lessonMany, String title) {
        this.id = id;
        this.lessonMany = lessonMany;
        this.title = title;
    }

    public Module(Integer id, List<Lesson> lessonMany, String title, Course course) {
        this.id = id;
        this.lessonMany = lessonMany;
        this.title = title;
        this.course = course;
    }

    public Integer getId() {
        return id;
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

    public List<Lesson> getLessonMany() {
        return lessonMany;
    }

    public void setLessonMany(List<Lesson> lessonMany) {
        this.lessonMany = lessonMany;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
