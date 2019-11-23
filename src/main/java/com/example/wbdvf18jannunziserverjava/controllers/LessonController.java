package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Lesson;
import com.example.wbdvf18jannunziserverjava.models.Module;
import com.example.wbdvf18jannunziserverjava.repositories.LessonRepository;
import com.example.wbdvf18jannunziserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LessonController {
    @Autowired
    LessonRepository repository;

    @GetMapping("/api/modules/{moduleId}/lessons")
    public List<Lesson> findAllCourses(
            @PathVariable("moduleId") Integer moduleId) {
        return repository.findLessonForModule(moduleId);
    }

    @GetMapping("/api/lessons/{lessonId}")
    public Lesson findLessonById(
            @PathVariable("lessonId") Integer lessonId) {
        return repository.findLessonById(lessonId);
    }
}
