package machineCoding.bookmyshow.services;

import java.util.List;
import java.util.Map;
import machineCoding.bookmyshow.models.Seat;
import machineCoding.bookmyshow.models.SeatType;
import machineCoding.bookmyshow.models.Theatre;

public class InMemoryTheatreService implements TheatreService {
    private final Map<Integer, Theatre> theatreMap;

    public InMemoryTheatreService(final Map<Integer, Theatre> theatreMap) {
        this.theatreMap = theatreMap;
    }

    @Override
    public Map<SeatType, List<Seat>> getSeatConfiguration(final int theatreId, final int screenId) {
        return theatreMap.get(theatreId).getScreen(screenId).getSeatConfiguration();
    }
}
