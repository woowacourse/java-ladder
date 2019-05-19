package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Line> ladder;

    private LadderGame(final List<Line> ladder) {
        this.ladder = ladder;
    }

    public static LadderGame generateLadder(Height height, Person person) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(Line.generatePoints(person.getCountOfPerson())));
        }
        return new LadderGame(lines);
    }

    public GameResult generateAllResults(Person person, Result result) {
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0; i < person.getCountOfPerson(); i++) {
            resultIndex.add(generateResult(i + 1));
        }
        return new GameResult(resultIndex, person, result);
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
