package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Course;
import com.example.wbdvf18jannunziserverjava.models.Widget;
import com.example.wbdvf18jannunziserverjava.services.CourseService;
import com.example.wbdvf18jannunziserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class CourseController {
    CourseService service;

    @PostMapping("/api/courses")
    public List<Course> createCourse(
            @RequestBody Course course){
        service.createCourse(course);
        return service.findAllCourses();
    }

    @PutMapping("/api/courses/{courseId}")
    public List<Course> updateCourse(
            @PathVariable("courseId") Integer id,
            @RequestBody Course course
    ){
        service.updateCourse(id, course);
        return service.findAllCourses();
    }

    @DeleteMapping("api/courses/{courseId}")
    public List<Course> deleteCourse(
            @PathVariable("courseId") Integer id) {
        service.deleteCourse(id);
        return service.findAllCourses();
    }

    @GetMapping("api/courses")
    public List<Course> findAllCourse() {
        return service.findAllCourses();
    }

    @GetMapping("api/courses/{courseId}")
    public Course findCourseById(
            @PathVariable("courseId") Integer id) {
        return service.findCourseById(id);
    }

}
