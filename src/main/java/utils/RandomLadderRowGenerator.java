package utils;

import domain.LadderRow;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderRowGenerator implements LadderRowGenerator {

    private final Random random = new Random();

    @Override
    public LadderRow generate(final int userCount) {
        List<Line> lines = getLines(userCount);
        return new LadderRow(lines);
    }

    private List<Line> getLines(final int userCount) {
        List<Line> lines = new ArrayList<>();
        Line previousLine = Line.NOT_EXIST;
        for (int i = 0; i < userCount - 1; i++) {
            Line line = getLine(previousLine);
            lines.add(line);
            previousLine = line;
        }
        return lines;
    }

    private Line getLine(final Line line) {
        if (line == Line.NOT_EXIST) {
            boolean isExist = random.nextBoolean();
            return Line.from(isExist);
        }
        return Line.NOT_EXIST;
    }
}
