package machineCoding.snakeAndLadder.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import machineCoding.snakeAndLadder.models.Cell;
import machineCoding.snakeAndLadder.models.Actors;

public class BoardCellImpl implements Board {
    private final int N;
    private final int M;
    private final Map<Cell, Actors> snakes;
    private final Map<Cell, Actors> ladders;
    static final Cell START = new Cell(0, 0);

    public BoardCellImpl(final int N, final int M, final List<Actors> snakes, final List<Actors> ladders) {
        this.N = N;
        this.M = M;

        this.snakes = new HashMap<>();
        snakes.stream()
            .filter(snake -> isValid(snake.getStart()) && isValid(snake.getEnd()))
            .forEach(snake -> this.snakes.put(snake.getStart(), new Actors(snake)));

        this.ladders = new HashMap<>();
        ladders.stream()
            .filter(ladder -> isValid(ladder.getStart()) && isValid(ladder.getEnd()))
            .forEach(ladder -> this.ladders.put(ladder.getStart(), new Actors(ladder)));
    }

    @Override
    public Cell getPosition(final Cell currentPosition, final int num) {
        final int distanceFromStart = (currentPosition.getI() * N + currentPosition.getJ()) + num;
        final int newI = distanceFromStart / N;
        final int newJ = distanceFromStart % N;

        if (newI >= N) {
            System.out.println("Cant move as its beyond the board");
            return currentPosition;
        } else {
            return applySnakeAndLadder(new Cell(newI, newJ));
        }
    }

    @Override
    public Cell getStart() {
        return START;
    }

    private Cell applySnakeAndLadder(final Cell currentCell) {
        if (snakes.containsKey(currentCell)) {
            System.out.println("OOps! Snake ate at " + currentCell);
            return new Cell(snakes.get(currentCell).getEnd().getI(), snakes.get(currentCell).getEnd().getJ());
        }
        if (ladders.containsKey(currentCell)) {
            System.out.println("Wow found a ladder at " + currentCell);
            return new Cell(ladders.get(currentCell).getEnd().getI(), ladders.get(currentCell).getEnd().getJ());
        }
        return currentCell;
    }

    public boolean isEnd(final Cell currentCell) {
        return currentCell.getI() == N - 1 && currentCell.getJ() == M - 1;
    }

    private boolean isValid(final Cell cell) {
        return cell.getI() >= 0 && cell.getI() < N && cell.getJ() >= 0 && cell.getJ() < M;
    }
}
