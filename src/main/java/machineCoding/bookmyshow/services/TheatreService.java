package machineCoding.bookmyshow.services;

import java.util.List;
import java.util.Map;
import machineCoding.bookmyshow.models.Seat;
import machineCoding.bookmyshow.models.SeatType;

public interface TheatreService {
    Map<SeatType, List<Seat>> getSeatConfiguration(int theatreId, int screenId);
}
