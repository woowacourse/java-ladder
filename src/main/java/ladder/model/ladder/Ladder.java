package ladder.model.ladder;

import ladder.model.player.Players;
import ladder.model.linepointsgenerator.LinePointsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String NEW_LINE = "\n";
    private final int height;
    private List<Line> lines = new ArrayList<>();

    public Ladder(LinePointsGenerator linePointsGenerator, int height) {
        if (!this.isValidHeight(height)) {
            throw new IllegalArgumentException("높이는 1 이상의 정수이어야 합니다.");
        }
        this.height = height;
        IntStream.range(0, height).forEach(i -> lines.add(new Line(linePointsGenerator.generatePoints())));
    }

    private boolean isValidHeight(int height) {
        return height >= MIN_LADDER_HEIGHT;
    }

    public void move(Players players) {
        lines.forEach(line -> line.moveOneLine(players));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            stringBuilder.append(lines.get(i)).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
