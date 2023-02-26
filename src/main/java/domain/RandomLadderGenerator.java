package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public Ladder generate(Players players, ResultsEntry resultsEntry, int height) {
        List<Line> result = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            result.add(new Line(getHorizontalLineMovements(players.getCount())));
        }
        return new Ladder(players, resultsEntry, result);
    }

    private List<Boolean> getHorizontalLineMovements(int width) {
        List<Boolean> movements = new ArrayList<>(width);
        movements.add(random.nextBoolean());
        int inBetweenCount = width - 1;
        for (int index = 1; index < inBetweenCount; index++) {
            int previousElement = index - 1;
            updateResult(movements, movements.get(previousElement));
        }
        return movements;
    }

    private void updateResult(List<Boolean> result, Boolean previousElement) {
        if (previousElement) {
            result.add(Boolean.FALSE);
            return;
        }
        result.add(random.nextBoolean());
    }
}
