package com.example.wbdvf18jannunziserverjava.models;

import java.util.List;

public class Topic {
    Integer id;
    List<Widget> widgetMany;
    String title;

    public Topic(Integer id) {
        this.id = id;
    }

    public Topic(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Topic(Integer id, List<Widget> widgetMany, String title) {
        this.id = id;
        this.widgetMany = widgetMany;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public List<Widget> getWidgetMany() {
        return widgetMany;
    }

    public void setWidgetMany(List<Widget> widgetMany) {
        this.widgetMany = widgetMany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
