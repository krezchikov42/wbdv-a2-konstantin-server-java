package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Widget;
import com.example.wbdvf18jannunziserverjava.repositories.WidgetRepository;
import com.example.wbdvf18jannunziserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    
    WidgetService service;

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(
            @RequestBody Widget widget) {
        this.service.createWidget(widget);
        return  this.service.findAllWidgets();
    }

    @PutMapping("/api/widgets/{widgetId}")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") Integer id,
            @RequestBody Widget newWidget
    ) {
        this.service.updateWidget(id,newWidget);
        return  this.service.findAllWidgets();
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(
            @PathVariable("widgetId") Integer id) {
       this.service.deleteWidget(id);
        return this.service.findAllWidgets();
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidget() {
        return this.service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") Integer id) {
        return service.findWidgetById(id);
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
