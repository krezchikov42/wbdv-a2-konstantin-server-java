package com.example.wbdvf18jannunziserverjava.controllers;

import com.example.wbdvf18jannunziserverjava.models.MovieReview;
import com.example.wbdvf18jannunziserverjava.repositories.MovieReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class MovieReviewController {
    @Autowired
    MovieReviewRepository repository;

    @GetMapping("/api/review/{imdbID}")
    public MovieReview findMovieReviewByImdbId(
            @PathVariable("imdbID")
            String imdbID) {
        return repository.findMovieReviewByImdbId(imdbID);
    }

    @PostMapping("/api/reviews")
    public MovieReview createMovieReview(
            @RequestBody MovieReview review) {
        return repository.save(review);
    }
}
