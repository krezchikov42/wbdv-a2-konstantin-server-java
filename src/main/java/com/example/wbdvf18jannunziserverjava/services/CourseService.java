package com.example.wbdvf18jannunziserverjava.services;

import com.example.wbdvf18jannunziserverjava.models.Course;
import com.example.wbdvf18jannunziserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    List<Course> courseMany;

    public CourseService() {
        this.courseMany = new ArrayList<>();
        Course c1 = new Course(123, "Course 1");
        Course c2 = new Course(456, "Course 2");
        Course c3 = new Course(789, "Course 3");
        this.courseMany.add(c1);
        this.courseMany.add(c2);
        this.courseMany.add(c3);
    }

    public List<Course> createCourse(Course course) {
        this.courseMany.add(course);
        return this.courseMany;
    }

    public List<Course> findAllCourses() {
        return this.courseMany;
    }

    public Course findCourseById(Integer cid) {
        Course retCourse = this.courseMany.stream()
                .filter(course -> cid.equals(course.getId()))
                .findAny()
                .orElse(null);
        return retCourse;
    }

    public Course updateCourse(Integer cid, Course newCourse) {
        for (int i = 0; i < this.courseMany.size(); i++) {
            Course course1 = courseMany.get(i);
            if (course1.getId().equals(newCourse.getId())) {
                courseMany.set(i, newCourse);
                return newCourse;
            }
        }
        return null;
    }

    public void deleteCourse(Integer cid) {
        for (int i = 0; i < this.courseMany.size(); i++) {
            Course course = courseMany.get(i);
            if (course.getId() == cid) {
                courseMany.remove(cid);
            }
        }
    }

}

