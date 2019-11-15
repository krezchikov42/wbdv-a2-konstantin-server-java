package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Course;
import com.example.wbdvf18jannunziserverjava.models.Module;
import com.example.wbdvf18jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvf18jannunziserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ModuleController {
    @Autowired
    ModuleRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/courses/{courseId}/modules")
    public List<Module> findAllCourses(
            @PathVariable("courseId") Integer courseId) {
        return repository.findModulesForCourse(courseId);
    }

    @PostMapping("api/courses/{courseId}/modules")
    public List<Module> createModule(
            @PathVariable("courseId") Integer courseId,
            @RequestBody Module module
    ){
        Course course = courseRepository.findCourseById(courseId);
        module.setCourse(course);
        repository.save(module);
        return course.getModuleMany();
    }

    @GetMapping("api/modules/{moduleId}")
    public Module findModuleById(
            @PathVariable("moduleId") Integer moduleId
    ){
        Module module = repository.findModuleForId(moduleId);
        return  module;
    }

    @PutMapping("api/modules/{moduleId}")
    public List<Module> updateModule(
            @PathVariable("moduleId") Integer moduleId,
            @RequestBody Module module
    ){
        repository.save(module);
        Integer courseId =  module.getCourse().getId();
        return repository.findModulesForCourse(courseId);
    }

    @DeleteMapping("api/modules/{moduleId}")
    public List<Module> deleteModule(
            @PathVariable("moduleId") Integer moduleId
            ){
        Integer courseId = repository.findModuleForId(moduleId).getCourse().getId();
        repository.deleteById(moduleId);
        return  repository.findModulesForCourse(courseId);
    }
}
