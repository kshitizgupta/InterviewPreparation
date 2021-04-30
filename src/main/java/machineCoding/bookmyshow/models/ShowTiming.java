package machineCoding.bookmyshow.models;

import java.time.Instant;

public class ShowTiming {
    private final Instant startTime;
    private final Instant endTime;

    public ShowTiming(final Instant startTime, final Instant endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }
}
