package ladder.domain;

import ladder.util.RandomHelper;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Line> ladder;

    public LadderGame(final List<Line> ladder) {
        this.ladder = ladder;
    }

    public static List<Line> generateAllPoints(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(generatePoints(countOfPerson)));
        }
        return lines;
    }

    private static List<Boolean> generatePoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        for (int j = 0; j < countOfPerson; j++) {
            points.add(RandomHelper.randomPoint(points, countOfPerson));
        }
        points.add(false);
        return points;
    }

    public ResultProcessor generateAllResults(LadderGameData ladderGameData) {
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0; i < ladderGameData.getPerson().getCountOfPerson(); i++) {
            resultIndex.add(generateResult(i + 1));
        }
        return new ResultProcessor(resultIndex, ladderGameData);
    }

    private int generateResult(int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder) {
            sb.append(line.makeLine());
        }
        return sb.toString();
    }
}
