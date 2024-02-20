package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> isDrawn;
    public Line(int number) {
        isDrawn = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            isDrawn.add(false);
        }
    }
}
