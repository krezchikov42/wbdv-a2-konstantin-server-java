package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Topic;
import com.example.wbdvf18jannunziserverjava.models.Widget;
import com.example.wbdvf18jannunziserverjava.repositories.TopicRepository;
import com.example.wbdvf18jannunziserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetRepository repository;

    @Autowired
    TopicRepository topicRepository;

    public WidgetController() {
    }

    @PostMapping("/api/topics/{topicId}/widgets")
    public List<Widget> createWidgetForTopic(
            @PathVariable("topicId") Integer id,
            @RequestBody Widget widget) {
        Topic topic = topicRepository.findTopicById(id);
        widget.setTopic(topic);
        repository.save(widget);
        return topic.getWidgetMany();
    }

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> getWidgetsForTopic(
            @PathVariable("topicId") Integer id){
        Topic topic = topicRepository.findTopicById(id);
        return topic.getWidgetMany();
    }

    @PutMapping("/api/widgets/{widgetId}")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") Integer id,
            @RequestBody Widget newWidget
    ) {
        repository.save(newWidget);
        Topic topic = newWidget.getTopic();
        return topic.getWidgetMany();
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(
            @PathVariable("widgetId") Integer id) {
        Topic topic = repository.findWidgetById(id).getTopic();
       repository.deleteById(id);
       return   topic.getWidgetMany();
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidget() {
        return repository.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") Integer id) {
        return repository.findWidgetById(id);
    }


    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello!";
    }
    @GetMapping("/get/widget")
    public Widget getWidget() {
        Widget w = new Widget(123, "Heading 1");
        return w;
    }
}
