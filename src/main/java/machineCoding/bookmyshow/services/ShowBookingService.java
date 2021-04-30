package machineCoding.bookmyshow.services;

import java.util.List;
import java.util.UUID;
import machineCoding.bookmyshow.models.SeatType;
import machineCoding.bookmyshow.models.Show;
import machineCoding.bookmyshow.models.UserBookingRecord;

public interface ShowBookingService {
    void add(Show show);

    List<Show> getAll();

    UserBookingRecord reserve(final UUID showId, final SeatType seatType, final int noOfSeats);

    void confirm(final UUID userBookingRecordId);
}
