package machineCoding.bookmyshow.models;

import java.time.Instant;
import java.util.UUID;

public class Show {
    private final UUID id;
    private final String movieId;
    private final int theatreId;
    private final int screenId;
    private final Instant date;
    private final ShowTiming showTiming;

    public Show(final UUID id, final String movieId, final int theatreId, final int screenId, final Instant date, final ShowTiming showTiming) {
        this.id = id;
        this.movieId = movieId;
        this.theatreId = theatreId;
        this.screenId = screenId;
        this.date = date;
        this.showTiming = showTiming;
    }

    public Show(final Show show) {
        this.id = show.id;
        this.movieId = show.movieId;
        this.theatreId = show.theatreId;
        this.screenId = show.screenId;
        this.showTiming = show.showTiming;
        this.date = show.date;
    }

    public UUID getId() {
        return id;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public int getScreenId() {
        return screenId;
    }

    public ShowTiming getShowTiming() {
        return showTiming;
    }
}
