package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONAL_LINE = "-----";
    private static final String LINE_SPACE = "     ";

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(RandomGenerator.getRandomBoolean());

        for (int i = 1; i < countOfPerson - 1; ++i) {
            points.add(RandomGenerator.getRandomBoolean(points.get(i - 1)));
        }
    }

    public int getNextPositon(Player player) {
        return player.trymove(points);
    }

    @Override
    public String toString() {
        List<String> lineElements = new ArrayList<>();

        for (boolean point : points) {
            lineElements.add((point) ? HORIZONAL_LINE : LINE_SPACE);
        }

        return VERTICAL_LINE
                + String.join(VERTICAL_LINE, lineElements)
                + VERTICAL_LINE;
    }
}
