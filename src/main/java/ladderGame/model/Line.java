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
        isDrawn.add(new Random().nextBoolean());
        for(int i = 1; i < number-1; i++) {
            if(isDrawn.get(i - 1)) {
                isDrawn.add(false);
                continue;
            }
            isDrawn.add(new Random().nextBoolean());
        }
    }

    public List<Boolean> getIsDrawn() {
        return new ArrayList<>(isDrawn);
    }

}
