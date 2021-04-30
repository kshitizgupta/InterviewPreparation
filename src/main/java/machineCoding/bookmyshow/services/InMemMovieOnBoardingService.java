package machineCoding.bookmyshow.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import machineCoding.bookmyshow.models.Movie;
import machineCoding.bookmyshow.models.Show;
import machineCoding.bookmyshow.models.ShowTiming;

public class InMemMovieOnBoardingService implements MovieOnBoardingService {
    private final TheatreService theatreService;
    private final MovieService movieService;
    private final ShowBookingService showBookingService;

    public InMemMovieOnBoardingService(final TheatreService theatreService, final MovieService movieService, final ShowBookingService showBookingService) {
        this.theatreService = theatreService;
        this.movieService = movieService;
        this.showBookingService = showBookingService;
    }

    @Override
    public void addMovie(
        final Movie movie,
        final int theatreId,
        final int screenId,
        final Instant startDate,
        final Instant endDate,
        final List<ShowTiming> showTimingsPerDay
    ) {
        movieService.addMovie(movie);

        showTimingsPerDay.forEach(showTiming -> {
            createShows(movie.getName(), theatreId, screenId, startDate, endDate, showTiming);
        });
    }

    @Override
    public List<Show> createShows(
        final String movieId,
        final int theatreId,
        final int screenId,
        final Instant startDate,
        final Instant endDate,
        final ShowTiming showTiming
    ) {
        final List<Show> shows = new ArrayList<>();

        Instant currDate = startDate.truncatedTo(ChronoUnit.DAYS);
        Instant finishDate = endDate.truncatedTo(ChronoUnit.DAYS);

        long noOfDays = ChronoUnit.DAYS.between(endDate, currDate);

        for (int i = 1; i <= noOfDays; i++) {
            final Show show = new Show(UUID.randomUUID(), movieId, theatreId, screenId, currDate, showTiming);
            currDate = currDate.plus(1, ChronoUnit.DAYS);
            shows.add(show);
            showBookingService.add(show);
        }
        return shows;
    }
}
