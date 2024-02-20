package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> isDrawn;
    public Line(int number) {
        isDrawn = new ArrayList<>();
        draw(number);
    }

    private void draw(int number) {
        for(int i = 0; i < number-1; i++) {
            drawSpace(i);
        }
    }

    private void drawSpace(int index) {
        if(index == 0 || !isDrawn.get(index - 1)) {
            isDrawn.add(new Random().nextBoolean());
            return;
        }
        isDrawn.add(false);
    }

    public List<Boolean> getIsDrawn() {
        return new ArrayList<>(isDrawn);
    }

}
