package machineCoding.snakeAndLadder.services;

import machineCoding.snakeAndLadder.models.Cell;

public interface Board {
    Cell getPosition(Cell currentPosition, int num);
    Cell getStart();
    boolean isEnd(Cell currentPosition);
}
