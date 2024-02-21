package ladder.model;

import ladder.constant.LadderPath;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(LadderSize ladderSize) {
        List<Line> ladder = new ArrayList<>();

        int height = ladderSize.getHeight();
        int width = ladderSize.getWidth();

        for (int i = 0; i < height; i++) {
            Line line = new Line(IntStream.range(0, width)
                    .mapToObj(unused -> LadderPath.STAY)
                    .toList());
            ladder.add(line);
        }

        return new Ladder(ladder);
    }

    public LadderSize getSize() {
        return new LadderSize(ladder.size(), ladder.get(0).size());
    }


}
