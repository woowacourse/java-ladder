package ladder.domain;

import ladder.util.RandomHelper;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder newLadder(LadderGameData ladderGameData) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderGameData.getHeight(); i++) {
            lines.add(new Line(generateOneLine(ladderGameData.getPerson().getCountOfPerson())));
        }
        return new Ladder(lines);
    }

    private static List<Boolean> generateOneLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int j = 0; j < countOfPerson; j++) {
            points.add(RandomHelper.randomPoint(points, countOfPerson));
        }
        points.add(false);
        return points;
    }

    int moveStartToEnd(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line.drawLadder());
        }
        return sb.toString();
    }
}
