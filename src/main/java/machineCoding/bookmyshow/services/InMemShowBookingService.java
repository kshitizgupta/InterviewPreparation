package machineCoding.bookmyshow.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import machineCoding.bookmyshow.models.BookingStatus;
import machineCoding.bookmyshow.models.Seat;
import machineCoding.bookmyshow.models.SeatType;
import machineCoding.bookmyshow.models.Show;
import machineCoding.bookmyshow.models.ShowInventory;
import machineCoding.bookmyshow.models.UserBookingRecord;

public class InMemShowBookingService implements ShowBookingService {
    private final Map<UUID, ShowInventory> showBookingRecordMap;
    private final Map<UUID, Show> currentRunningShows;
    private final TheatreService theatreService;
    private final Map<UUID, UserBookingRecord> ordersInProcessing;

    public InMemShowBookingService(final TheatreService theatreService) {
        this.theatreService = theatreService;
        this.showBookingRecordMap = new ConcurrentHashMap<>();
        this.currentRunningShows = new HashMap<>();
        ordersInProcessing = new HashMap<>();
    }

    @Override
    public void add(final Show show) {
        currentRunningShows.put(show.getId(), show);
        //get seats of this show
        Map<SeatType, List<Seat>> seatConfig = theatreService.getSeatConfiguration(show.getTheatreId(), show.getScreenId());
        showBookingRecordMap.put(show.getId(), new ShowInventory(show.getId(), seatConfig));
    }

    @Override
    public List<Show> getAll() {
        return new ArrayList<>(currentRunningShows.values());
    }

    @Override
    public UserBookingRecord reserve(final UUID showId, final SeatType seatType, final int noOfSeatsRequested) {
        final ShowInventory showRequested = showBookingRecordMap.get(showId);

        if (showRequested.getAvailableSeatsCount(seatType) > noOfSeatsRequested) {
            List<String> seats = showRequested.allotSeats(seatType, noOfSeatsRequested);
            final Show show = currentRunningShows.get(showRequested.getShowId());

            UserBookingRecord record = new UserBookingRecord(
                UUID.randomUUID(),
                Instant.now(),
                BookingStatus.PENDING_PAYMENT,
                show.getShowTiming(),
                show.getTheatreId(),
                show.getScreenId(),
                seats,
                seatType
            );

            ordersInProcessing.put(record.getId(), record);

            return record;
        } else {
            return null;
        }
    }

    @Override
    public void confirm(final UUID userBookingId) {
        if (ordersInProcessing.containsKey(userBookingId)) {
            final UserBookingRecord userBookingRecord = ordersInProcessing.remove(userBookingId);
            userBookingRecord.setStatus(BookingStatus.COMPLETED);
        }
    }

    private void release(final UUID userBookingId) {
        final UserBookingRecord bookingRecord = ordersInProcessing.remove(userBookingId);
        showBookingRecordMap.get(bookingRecord.getId()).returnSeats(bookingRecord.getSeats(), bookingRecord.getSeatType());
    }
}
