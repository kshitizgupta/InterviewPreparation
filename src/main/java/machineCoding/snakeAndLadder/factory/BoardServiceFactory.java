package machineCoding.snakeAndLadder.factory;

import java.util.List;
import machineCoding.snakeAndLadder.services.BoardCellImpl;
import machineCoding.snakeAndLadder.models.Actors;
import machineCoding.snakeAndLadder.models.Player;
import machineCoding.snakeAndLadder.services.BoardService;

public class BoardServiceFactory {
    public static BoardService getBoard(
        final int n,
        final int m,
        final List<Actors> snakes,
        final List<Actors> ladders,
        final List<Player> playerList
    ) {
        BoardCellImpl board = new BoardCellImpl(5,5, snakes, ladders);
        return new BoardService(playerList, board);
    }
}