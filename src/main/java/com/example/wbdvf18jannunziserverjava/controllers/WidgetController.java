package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Widget;
import com.example.wbdvf18jannunziserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetRepository repository;

    public WidgetController() {
    }

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(
            @RequestBody Widget widget) {
        repository.save(widget);
        return  (List<Widget>) repository.findAll();
    }

    @PutMapping("/api/widgets/{widgetId}")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") Integer id,
            @RequestBody Widget newWidget
    ) {
        repository.save(newWidget);
        return repository.findAllWidgets();
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(
            @PathVariable("widgetId") Integer id) {
       repository.deleteById(id);
       return   repository.findAllWidgets();
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
