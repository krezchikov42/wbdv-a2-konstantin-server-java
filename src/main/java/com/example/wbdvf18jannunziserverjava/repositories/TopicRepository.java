package com.example.wbdvf18jannunziserverjava.repositories;

import com.example.wbdvf18jannunziserverjava.models.Topic;
import com.example.wbdvf18jannunziserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {
    @Query("select topic from Topic topic")
    public List<Topic> findAllTopics();

    @Query("select topic from Topic topic where topic.id=:topicId")
    public Topic findTopicById(@Param("topicId") Integer id);
}
