package machineCoding.bookmyshow.models;

import java.util.Map;

public class SeatConfiguration {
    private final Map<SeatType, Integer> seatTypeMap;

    public SeatConfiguration(final Map<SeatType, Integer> seatTypeMap) {
        this.seatTypeMap = seatTypeMap;
    }

    public Map<SeatType, Integer> getSeatTypeMap() {
        return Map.copyOf(seatTypeMap);
    }
}
