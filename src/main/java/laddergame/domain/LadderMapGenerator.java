package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMapGenerator {
    static List<Line> fillLadder(int width, int height) {
        List<Line> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(LineGenerator.makeLine(width));
        }

        return ladder;
    }
}