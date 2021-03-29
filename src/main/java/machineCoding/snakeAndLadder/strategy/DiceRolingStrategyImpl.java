package machineCoding.snakeAndLadder.strategy;

import java.util.Random;

public class DiceRolingStrategyImpl implements DiceRolingStrategy {

    @Override
    public int rollDice() {
        final int max = 6;
        final int min = 1;
        return new Random().nextInt(max - min + 1) + min;
    }
}
