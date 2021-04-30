package machineCoding.bookmyshow.services;

import java.time.Instant;
import java.util.List;
import machineCoding.bookmyshow.models.Movie;
import machineCoding.bookmyshow.models.Show;
import machineCoding.bookmyshow.models.ShowTiming;

public interface MovieOnBoardingService {
    void addMovie(
        Movie movie,
        int theatreId,
        int screenId,
        Instant startDate,
        Instant endDate,
        List<ShowTiming> showTimingsPerDay
    );

    List<Show> createShows(
        String movieId,
        int theatreId,
        int screenId,
        Instant startDate,
        Instant endDate,
        ShowTiming showTiming
    );
}
