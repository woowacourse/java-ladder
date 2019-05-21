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
        return GameResult.generateGameResult(resultIndex, person, result);
    }

    private int generateResult(int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
