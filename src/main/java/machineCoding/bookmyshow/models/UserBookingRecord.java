package machineCoding.bookmyshow.models;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class UserBookingRecord {
    private final UUID id;
    private final Instant bookingTime;
    private BookingStatus status;
    private final ShowTiming showTiming;
    private final int theatreId;
    private final int screenId;
    private final List<String> seats;
    private final SeatType seatType;

    public UserBookingRecord(
        final UUID id,
        final Instant bookingTime,
        final BookingStatus status,
        final ShowTiming showTiming,
        final int theatreId,
        final int screenId,
        final List<String> seats,
        final SeatType seatType
    ) {
        this.id = id;
        this.bookingTime = bookingTime;
        this.status = status;
        this.showTiming = showTiming;
        this.theatreId = theatreId;
        this.screenId = screenId;
        this.seats = seats;
        this.seatType = seatType;
    }

    public UUID getId() {
        return id;
    }

    public Instant getBookingTime() {
        return bookingTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public ShowTiming getShowTiming() {
        return showTiming;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setStatus(final BookingStatus status) {
        this.status = status;
    }

    public List<String> getSeats() {
        return seats;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
