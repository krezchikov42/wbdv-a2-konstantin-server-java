package com.example.wbdvf18jannunziserverjava.repositories;

import com.example.wbdvf18jannunziserverjava.models.Lesson;
import com.example.wbdvf18jannunziserverjava.models.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository
        extends CrudRepository<Lesson, Integer> {
    @Query("select lesson from Lesson lesson where lesson.module.id=:moduleId")
    public List<Lesson> findLessonForModule(
            @Param("moduleId") Integer id
    );

    @Query("select lesson from Lesson lesson where lesson.id=:lessonId")
    public Lesson findLessonById(@Param("lessonId") Integer id);
}
