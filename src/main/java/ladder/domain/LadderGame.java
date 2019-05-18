package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Line> ladder;

    public LadderGame(final List<Line> ladder) {
        this.ladder = ladder;
    }

    public static List<Line> generateLadder(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(Line.generatePoints(countOfPerson)));
        }
        return lines;
    }

    private int generateResult(int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }
        return index;
    }

    public ResultProcessor generateAllResults(Person person, Result result) {
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0; i < person.getCountOfPerson(); i++) {
            resultIndex.add(generateResult(i + 1));
        }
        return new ResultProcessor(resultIndex, person, result);
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
