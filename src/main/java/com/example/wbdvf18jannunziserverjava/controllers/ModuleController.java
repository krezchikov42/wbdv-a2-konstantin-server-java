package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Course;
import com.example.wbdvf18jannunziserverjava.models.Module;
import com.example.wbdvf18jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvf18jannunziserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ModuleController {
    @Autowired
    ModuleRepository repository;

    @GetMapping("/api/courses/{courseId}/modules")
    public List<Module> findAllCourses(
            @PathVariable("courseId") Integer courseId) {
        return repository.findModulesForCourse(courseId);
    }
}
