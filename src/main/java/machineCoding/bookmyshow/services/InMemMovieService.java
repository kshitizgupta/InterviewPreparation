package machineCoding.bookmyshow.services;

import java.util.Map;
import machineCoding.bookmyshow.models.Movie;

public class InMemMovieService implements MovieService {
    private final Map<String, Movie> movies;

    public InMemMovieService(final Map<String, Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovie(final String name) {
        return movies.get(name);
    }

    public void addMovie(final Movie movie) {
        movies.put(movie.getName(), movie);
    }

}
