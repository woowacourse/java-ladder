package ladder.domain;


import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int countOfPerson;
    private int ladderHeight;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderHeight) {
        this.countOfPerson = countOfPerson;
        this.ladderHeight = ladderHeight;

        createLadder();
    }

    private void createLadder() {
        for (int i = 1; i <= ladderHeight; i++) {
            lines.add(new LineGenerator(new RandomCreateLine()).drawLine(countOfPerson - 1));
        }
    }

    public List<Line> getLadder() {
        return lines;
    }
}