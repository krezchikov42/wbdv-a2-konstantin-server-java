package com.example.wbdvf18jannunziserverjava.services;

import com.example.wbdvf18jannunziserverjava.models.Widget;
import com.example.wbdvf18jannunziserverjava.models.WidgetType;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
    List<Widget> widget_many;

    public WidgetService() {
        widget_many= new ArrayList<>();
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
    }

    //Creates a new Widget instance and add it to the existing collection of widgets. Returns new list of widgets containing new widget
    public List<Widget> createWidget(Widget widget) {
        this.widget_many.add(widget);
        return  this.widget_many;
    }

    //Returns collection of all widgets
    public List<Widget> findAllWidgets(){
        return  this.widget_many;
    }

    //    Returns a single widget instance whose id is equal to wid
    public Widget findWidgetById( Integer wid){
        Widget return_widget = this.widget_many.stream()
                .filter(widget -> wid.equals(widget.getId()))
                .findAny()
                .orElse(null);
        return  return_widget;
    }

    //Updates widget whose id is wid encoded as JSON in HTTP body
    public Widget updateWidget(Integer wid, Widget widget) {
        for(int i = 0; i < this.widget_many.size(); i++) {
            Widget w = widget_many.get(i);
            if(w.getId().equals(wid)) {
                widget_many.set(i,widget);
                return widget;
            }
        }
        return null;
    }

    //Removes widget whose id is wid
    public void deleteWidget(Integer wid) {
        for(int i = 0; i < this.widget_many.size(); i++) {
            Widget w = widget_many.get(i);
            if(w.getId().equals(wid)) {
                widget_many.remove(i);
            }
        }
    }


}
