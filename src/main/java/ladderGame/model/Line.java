package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> isDrawns;

    public Line(int number) {
        isDrawns = new ArrayList<>();
        draw(number);
    }

    private void draw(int number) {
        for (int i = 0; i < number - 1; i++) {
            drawSpace(i);
        }
    }

    private void drawSpace(int index) {
        if (index == 0 || !isDrawns.get(index - 1)) {
            isDrawns.add(new Random().nextBoolean());
            return;
        }
        isDrawns.add(false);
    }

    public List<Boolean> getIsDrawns() {
        return new ArrayList<>(isDrawns);
    }

}
