package com.example.wbdvf18jannunziserverjava.repositories;

import com.example.wbdvf18jannunziserverjava.models.MovieReview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieReviewRepository
    extends CrudRepository<MovieReview, Integer> {
    @Query("SELECT review from MovieReview review WHERE review.imdbID=:imdbID")
    public MovieReview findMovieReviewByImdbId(@Param("imdbID") String imdbID);
}
