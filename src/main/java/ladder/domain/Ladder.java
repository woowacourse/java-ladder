package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Line getLine(int lineIndex) {
        return lines.get(lineIndex);
    }

    public List<Item> play(Items items) {
        List<Integer> ladderResult = playAllRound();
        List<Item> finalResult = LadderResult.generate(ladderResult, items);

        return finalResult;
    }

    private List<Integer> playAllRound() {
        List<Integer> ladderResult = new ArrayList<>();

        for (int i = 0; i < getNumberOfPeople(); i++) {
            int index = i;
            ladderResult.add(playOneRound(index));
        }

        return ladderResult;
    }

    private int playOneRound(int index) {
        for (int j = 0; j < lines.size(); j++) {
            Line line = lines.get(j);
            index = moveIndex(line, index);
        }
        return index;
    }

    private int moveIndex(Line line, int index) {
        if (index == 0) {
            return (line.isConnected(index)) ? index + 1 : index;
        }
        if (line.isConnected(index - 1)) return index - 1;
        if (line.isConnected(index)) return index + 1;

        return index;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getNumberOfPeople() {
        return lines.get(0).getNumberOfPeople();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
