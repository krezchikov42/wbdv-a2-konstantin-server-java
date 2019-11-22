package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Topic;
import com.example.wbdvf18jannunziserverjava.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsforLesson(
            @PathVariable("lessonId") Integer lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }

    @GetMapping("/api/topics/{topicId}")
    public Topic findLessonById(
            @PathVariable("topicId") Integer topicId) {
        return topicRepository.findTopicById(topicId);
    }
}

