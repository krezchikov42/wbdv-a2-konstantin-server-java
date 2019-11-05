package com.example.wbdvf18jannunziserverjava.services;

import com.example.wbdvf18jannunziserverjava.models.*;
import com.example.wbdvf18jannunziserverjava.models.Module;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    List<Course> courseMany;

    public CourseService() {
        this.courseMany = new ArrayList<>();

        List<Widget> widget_many= new ArrayList<>();
        Widget w1 = new Widget(123, "Widget 1");
        Widget w2 = new Widget(234, "Widget 2");
        Widget w3 = new Widget(345, "Widget 3");
        Widget w4 = new Widget(21321321, "Widget 4");
        Widget w5 = new Widget(2153, "Widget 5");

        w1.setType(WidgetType.LIST);
        w1.setOrdered(true);
        w1.setText( "Item 1\nItem 2\nItem 3");
        w2.setType(WidgetType.HEADING);
        w2.setSize(6);
        w2.setText("Hello from Server");
        w3.setType(WidgetType.PARAGRAPH);
        w3.setText("this is a paragraph");
        w4.setType(WidgetType.IMAGE);
        w4.setText("https://picsum.photos/100/100");
        w5.setType(WidgetType.LINK);
        w5.setText("Hello");
        w5.setUrl("https://getbootstrap.com/docs/4.0/components/forms/");
        widget_many.add(w1);
        widget_many.add(w2);
        widget_many.add(w3);
        widget_many.add(w4);
        widget_many.add(w5);
        Topic t = new Topic(12380, widget_many,  "topic");
        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(t);
        Lesson lesson = new Lesson(5576,"lesson", topics);
        ArrayList<Lesson> lessons = new ArrayList<Lesson>();
        lessons.add(lesson);
        Module m = new Module(123, lessons, "Hello");
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(m);
        Course c1 = new Course(123,modules, "Course 1");
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
            System.out.println(course.getId());
            if (course.getId().equals(cid)) {
                courseMany.remove(i);
            }
        }
    }

}

