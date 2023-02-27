package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import strategy.PassGenerator;

public class Ladder {

    private static final int MINIMUM_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int numberOfPlayer, PassGenerator passGenerator) {
        validateMinHeight(height);
        while (height > 0) {
            lines.add(new Line(numberOfPlayer, passGenerator));
            height -= 1;
        }
    }

    private void validateMinHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 최소 1 이상이어야 합니다");
        }
    }

    public int calculateResultIndex(int playerIndex) {
        int finalIndex = playerIndex;
        for (Line line : lines) {
            finalIndex = line.nextLineIndex(finalIndex);
        }
        return finalIndex;
    }

    public List<List<String>> getLadder() {
        return lines.stream()
            .map(Line::getLineBlockPass)
            .collect(Collectors.toList());
    }
}
