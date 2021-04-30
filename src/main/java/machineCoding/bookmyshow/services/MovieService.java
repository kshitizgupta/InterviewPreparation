package machineCoding.bookmyshow.services;

import machineCoding.bookmyshow.models.Movie;

public interface MovieService {
    Movie getMovie(final String name);

    void addMovie(final Movie movie);
}
