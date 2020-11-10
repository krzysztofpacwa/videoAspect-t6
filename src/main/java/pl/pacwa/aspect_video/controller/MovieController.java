package pl.pacwa.aspect_video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pacwa.aspect_video.model.Movie;
import pl.pacwa.aspect_video.service.MailAnnotation;
import pl.pacwa.aspect_video.service.MovieService;


@Controller
@RequestMapping("/")
public class MovieController {

    private MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getMoviesList(Model model ){
        model.addAttribute("movieList", movieService.getMovieList() );
        model.addAttribute("newMovie", new Movie());
        return "movie";
    }

    @MailAnnotation
    @PostMapping
    public String addMovie(@ModelAttribute Movie movie){
        movieService.addMovie(movie);
        return "redirect:/";
    }

}
