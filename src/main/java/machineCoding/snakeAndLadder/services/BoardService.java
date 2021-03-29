package machineCoding.snakeAndLadder.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import machineCoding.snakeAndLadder.models.Cell;
import machineCoding.snakeAndLadder.models.MoveResult;
import machineCoding.snakeAndLadder.models.MoveState;
import machineCoding.snakeAndLadder.models.Player;

public class BoardService {
    private final Map<Integer, Cell> playerPosition;
    private final Board board;

    public BoardService(final List<Player> players, final Board board) {
        this.board = board;
        playerPosition = new HashMap<>();
        players.forEach(player -> playerPosition.put(player.getId(), board.getStart()));
    }

    public MoveResult move(final int playerId, final int rolledDice) {
        final Cell positionBeforeMove = playerPosition.get(playerId);
        final Cell positionAfterMove = board.getPosition(playerPosition.get(playerId), rolledDice);

        playerPosition.put(playerId, positionAfterMove);

        if (board.isEnd(positionAfterMove)) {
            return new MoveResult(positionBeforeMove, positionAfterMove, MoveState.END);
        } else {
            return new MoveResult(positionBeforeMove, positionAfterMove, MoveState.OTHER);
        }
    }

}
