package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Integer> lines = new ArrayList<>();

    public Level(int width) {
        drawOrPass(0, width);
        System.out.println(lines);
    }

    private void drawOrPass(int target, int left) {
        if (Coin.toss() && left > 0) {
            lines.add(target);
            drawOrPass(target + 2, left - 2);
            return;
        }
        if (left > 0) {
            drawOrPass(target + 1, left - 1);
        }
    }

    public List<Integer> getLines() {
        return lines;
    }
}