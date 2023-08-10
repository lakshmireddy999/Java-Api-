package com.internshipproject.project.Controller;

import com.internshipproject.project.Entity.Movie;
import com.internshipproject.project.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class compare implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m2.getRating().compareTo(m1.getRating());
    }
}

@RestController
@Service
@CrossOrigin
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(path = "movie/update", consumes = "application/json", method = RequestMethod.POST)
    public String updateData(@RequestBody Movie movie) {
        Movie movie1 = Movie.builder()
                .image(movie.getImage())
                .ranking(movie.getRanking())
                .genre(movie.getGenre())
                .title(movie.getTitle())
                .year(movie.getYear())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .trailer(movie.getTrailer())
                .writers(movie.getWriters())
                .director(movie.getDirector())
                .thumbnail(movie.getThumbnail())
                .build();
        movieRepository.save(movie1);

        return "success";
    }

    @GetMapping(path = "movie/get")
    public List<Movie> getData() {
        List<Movie> response = movieRepository.findAll();

        Collections.sort(response, new compare());
        return response;
    }
}
