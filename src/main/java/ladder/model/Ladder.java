package ladder.model;

import ladder.utils.RandomBooleanGenerator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    // TODO: line의 왼쪽 경로 확인 메서드를 사용해야 함
    public static Ladder from(LadderHeight height, int width) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(Line.of(width, new RandomBooleanGenerator()));
        }
        return new Ladder(ladder);
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getWidth() {
        return ladder.get(0).size();
    }
}
