package com.example.wbdvf18jannunziserverjava.repositories;

import com.example.wbdvf18jannunziserverjava.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository
        extends CrudRepository<Course, Integer> {
    @Query("select course from Course course")
    public List<Course> findAllCourses();
}
