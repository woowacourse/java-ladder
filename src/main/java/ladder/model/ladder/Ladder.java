package ladder.model.ladder;

import ladder.model.player.Players;
import ladder.model.linepointsgenerator.LinePointsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String NEW_LINE = "\n";
    private List<Line> lines = new ArrayList<>();

    public Ladder(LinePointsGenerator linePointsGenerator, int height) {
        validateHeight(height);
        IntStream.range(0, height).forEach(i -> lines.add(new Line(linePointsGenerator.generatePoints())));
    }

    private void validateHeight(int height) {
        if(height < MIN_LADDER_HEIGHT){
            throw new IllegalArgumentException("높이는 1 이상의 정수이어야 합니다.");
        }
    }

    public void move(Players players) {
        lines.forEach(line -> line.moveOneLine(players));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.stream().forEach(line -> stringBuilder.append(line).append(NEW_LINE));

        return stringBuilder.toString();
    }
}