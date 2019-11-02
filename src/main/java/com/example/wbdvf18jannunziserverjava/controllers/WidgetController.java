package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.Widget;
import com.example.wbdvf18jannunziserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetRepository repository;

    List<Widget> widgets = new ArrayList<Widget>();
    {
        Widget w1 = new Widget(123, "Widget 1");
        Widget w2 = new Widget(234, "Widget 2");
        Widget w3 = new Widget(345, "Widget 3");
        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
    }

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(
            @RequestBody Widget widget) {
        repository.save(widget);
        return repository.findAllWidgets();
//        widgets.add(widget);
//        return widgets;
    }

    @PutMapping("/api/widgets/{widgetId}")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") Integer id,
            @RequestBody Widget newWidget
    ) {
        for(Widget w: widgets) {
            if(w.getId().equals(id)) {
                w.setTitle(newWidget.getTitle());
            }
        }
        return widgets;
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(
            @PathVariable("widgetId") Integer id) {
        int index = -1;
        for(int i=0; i<widgets.size()-1; i++) {
            if(widgets.get(i).getId().equals(id)) {
                index = i;
            }
        }
        widgets.remove(index);
        return widgets;
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidget() {
        return repository.findAllWidgets();
//        return (List<Widget>)repository.findAll();
//        return widgets;
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") Integer id) {
        return repository.findWidgetById(id);
//        Optional<Widget> w = repository.findById(id);
//        if(w.isPresent()) {
//            return w.get();
//        }
//        return null;
//        for(Widget w: widgets) {
//            if(w.getId().equals(id)) {
//                return w;
//            }
//        }
//        return null;
    }

    // createWidget
    // findAllWidgets
    // findWidgetById
    // updateWidget
    // deleteWidget

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
