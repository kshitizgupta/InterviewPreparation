package machineCoding.bookmyshow.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShowInventory {
    private final UUID showId;
    private final Map<SeatType, List<Seat>> availableSeats;
    private final List<Seat> bookedSeats;

    public ShowInventory(final UUID showId, final Map<SeatType, List<Seat>> availableSeats) {
        this.showId = showId;
        this.availableSeats = Map.copyOf(availableSeats);
        this.bookedSeats = new ArrayList<>();
    }

    public List<String> allotSeats(final SeatType seatType, final int count) {
        final List<Seat> seats = availableSeats.get(seatType);
        final List<String> seatIds = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            final Seat removed = seats.remove(0);
            seatIds.add(removed.getId());
            bookedSeats.add(removed);
        }
        return seatIds;
    }

    public void returnSeats(final List<String> seatIds, final SeatType seatType) {
        List<Seat> toReturn = new ArrayList<>();
        for(String seatId: seatIds) {
            for(Seat seat: bookedSeats) {
                if(seat.getId().equals(seatId)) {
                    toReturn.add(seat);
                }
            }
        }
        bookedSeats.removeAll(toReturn);
        availableSeats.get(seatType).addAll(toReturn);
    }

    public Map<SeatType, List<Seat>> getAvailableSeats() {
        return availableSeats;
    }

    public int getAvailableSeatsCount(final SeatType type) {
        return availableSeats.containsKey(type) ? availableSeats.get(type).size() : 0;
    }

    public UUID getShowId() {
        return showId;
    }
}
