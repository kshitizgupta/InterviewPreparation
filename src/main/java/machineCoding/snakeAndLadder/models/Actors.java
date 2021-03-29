package machineCoding.snakeAndLadder.models;

public class Actors {
    private final Cell start;
    private final Cell end;

    public Actors(final Actors snake) {
        this.start = snake.start;
        this.end = snake.end;
    }

    public Actors(final Cell start, final Cell end) {
        this.start = start;
        this.end = end;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }
}
