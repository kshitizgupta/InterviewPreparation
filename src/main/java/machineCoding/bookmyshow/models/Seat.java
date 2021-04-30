package machineCoding.bookmyshow.models;

public class Seat {
    final private String id;
    final private SeatType type;

    public Seat(final String id, final SeatType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public SeatType getType() {
        return type;
    }
}
