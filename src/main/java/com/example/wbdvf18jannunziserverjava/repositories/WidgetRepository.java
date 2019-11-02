package com.example.wbdvf18jannunziserverjava.repositories;

import com.example.wbdvf18jannunziserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

    @Query("select widget from Widget widget where widget.id=:widgetId")
    public Widget findWidgetById(@Param("widgetId") Integer id);

    @Query("select widget from Widget widget")
    public List<Widget> findAllWidgets();
}
