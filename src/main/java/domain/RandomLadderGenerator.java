package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public Lines generate(Players players, int height) {
        List<Line> result = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            result.add(new Line(getRandomMovements(players.getCount())));
        }
        return new Lines(result);
    }

    private List<Boolean> getRandomMovements(int width) {
        List<Boolean> movements = new ArrayList<>(width);
        movements.add(random.nextBoolean());
        int inBetweenCount = width - 1;
        for (int index = 1; index < inBetweenCount; index++) {
            int previousElement = index - 1;
            updateMovements(movements, movements.get(previousElement));
        }
        return movements;
    }

    private void updateMovements(List<Boolean> result, Boolean previousElement) {
        if (previousElement) {
            result.add(Boolean.FALSE);
            return;
        }
        result.add(random.nextBoolean());
    }
}
