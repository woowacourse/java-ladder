package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerateStrategy implements GenerateStrategy {

    private static final Random random = new Random();

    @Override
    public List<Line> generate(int width, int height) {
        List<Line> result = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            result.add(new Line(getHorizontalLineMovements(width)));
        }
        return result;
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
