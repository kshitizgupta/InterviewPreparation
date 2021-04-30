package machineCoding.snakeAndLadder;

import machineCoding.snakeAndLadder.strategy.DiceRolingStrategy;
import machineCoding.snakeAndLadder.strategy.DiceRolingStrategyImpl;

public class SnakeAndLadder {
    public static void main(String[] args) {
        final DiceRolingStrategy diceRolingStrategy = new DiceRolingStrategyImpl();
//        final GameOrchestrator gameOrchestrator = new GameOrchestrator(diceRolingStrategy);

//        gameOrchestrator.start();
    }
}
