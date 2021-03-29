package machineCoding.snakeAndLadder.models;

public class MoveResult {
    private final Cell start;
    private final Cell end;
    private final MoveState state;

    public MoveResult(final Cell start, final Cell end, final MoveState state) {
        this.start = start;
        this.end = end;
        this.state = state;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public MoveState getState() {
        return state;
    }
}
