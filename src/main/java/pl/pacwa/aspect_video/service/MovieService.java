package pl.pacwa.aspect_video.service;

import org.springframework.stereotype.Service;
import pl.pacwa.aspect_video.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> movieList;

    public MovieService(){
        movieList = new ArrayList<>();
        movieList.add(new Movie("Gladiator",1985));
        movieList.add(new Movie("Richard Jewell",2019));
        movieList.add(new Movie("Legiony",2019));
        movieList.add(new Movie("Bloodshot",2020));
        movieList.add(new Movie("Psy 3. W imię zasad",2020));
        movieList.add(new Movie("Rambo: Ostatnia krew",1985));

    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public boolean addMovie(Movie movie){
        return Optional.ofNullable(movie).map(m-> movieList.add(m)).orElse(false);
    }

}

