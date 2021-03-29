package machineCoding.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import machineCoding.Interactor;
import machineCoding.snakeAndLadder.factory.BoardServiceFactory;
import machineCoding.snakeAndLadder.models.Cell;
import machineCoding.snakeAndLadder.models.MoveResult;
import machineCoding.snakeAndLadder.models.MoveState;
import machineCoding.snakeAndLadder.models.Player;
import machineCoding.snakeAndLadder.models.Actors;
import machineCoding.snakeAndLadder.services.BoardService;
import machineCoding.snakeAndLadder.strategy.DiceRolingStrategy;

public class GameOrchestrator {
    private BoardService boardService;
    private List<Player> players;
    private final Interactor interactor;
    private final DiceRolingStrategy diceRolingStrategy;

    public GameOrchestrator(final DiceRolingStrategy diceRolingStrategy, final Interactor interactor) {
        this.diceRolingStrategy = diceRolingStrategy;
        this.interactor = interactor;
    }

    public void start() {
        initialize();
        run();
        exit();
    }

    private void exit() {
        interactor.close();
        System.out.println("Closing Game");
    }

    private void run() {
        int playerChance = 0;
        while (true) {
            //Figure out current player
            final Player currentPlayer = players.get(playerChance);

            interactor.waitForUserEntry(currentPlayer.getName() + "Enter anything to roll dice");
            final int diceRoll = diceRolingStrategy.rollDice();
            System.out.println("Rolling Dice, got : " + diceRoll);

            //Moving current player to new position
            final MoveResult moveResult = boardService.move(currentPlayer.getId(), diceRoll);

            //Printing Move Result
            printMoveResult(moveResult);

            if (MoveState.END.equals(moveResult.getState())) {
                System.out.println(currentPlayer + " wins");
                return;
            }
            playerChance = (playerChance + 1) % players.size();
        }
    }

    private void printMoveResult(final MoveResult moveResult) {
        System.out.println("Moved from " + moveResult.getStart() + " to " + moveResult.getEnd());
    }

    protected void initialize() {

        int noOfPlayers = interactor.getNoOfPlayers();
        players = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            players.add(new Player(i, interactor.getNextPlayerName()));
        }

        List<Actors> snakes = List.of(
            new Actors(new Cell(1, 0), new Cell(0, 0)),
            new Actors(new Cell(1, 2), new Cell(0, 0)),
            new Actors(new Cell(4, 3), new Cell(1, 0))
        );

        List<Actors> ladders = List.of(
            new Actors(new Cell(0, 3), new Cell(3, 0)),
            new Actors(new Cell(1, 3), new Cell(2, 0))
        );

        boardService = BoardServiceFactory.getBoard(5, 5, snakes, ladders, players);
    }
}
