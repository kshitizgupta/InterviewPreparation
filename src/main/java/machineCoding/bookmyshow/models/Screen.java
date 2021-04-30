package machineCoding.bookmyshow.models;

import java.util.List;
import java.util.Map;

public class Screen {
    private final int id;
    private final Map<SeatType, List<Seat>> seatConfiguration;

    public Screen(final int id, final Map<SeatType, List<Seat>> seatConfiguration) {
        this.id = id;
        this.seatConfiguration = seatConfiguration;
    }

    public int getId() {
        return id;
    }

    public Map<SeatType, List<Seat>> getSeatConfiguration() {
        return Map.copyOf(seatConfiguration);
    }
}
