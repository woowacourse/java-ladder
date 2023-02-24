package domain.model;

import domain.type.Line;
import domain.vo.Width;
import java.util.List;
import java.util.stream.IntStream;

public class Layer {

    private static final String LOCATION_NOT_EXIST = "층에 존재하지 않는 위치입니다.";
    private static final int LOCATION_DIFFERENCE = 1;
    private final List<Line> lines;
    private final BooleanGenerator booleanGenerator;

    public Layer(final List<Line> lines, final BooleanGenerator booleanGenerator) {
        this.lines = lines;
        this.booleanGenerator = booleanGenerator;
    }

    public void makeLine(final Width width) {
        if (lines.size() < width.getValue()) {
            int difference = width.getValue() - lines.size();
            generateLine(difference);
        }
    }

    private void generateLine(final int difference) {
        IntStream.range(0, difference)
            .forEach(index -> generateLine());
    }

    private void generateLine() {
        if (isPossibleToConnect()) {
            lines.add(Line.CONNECTED);
            return;
        }
        lines.add(Line.UNCONNECTED);
    }

    private boolean isPossibleToConnect() {
        return booleanGenerator.generate()
            && (lines.isEmpty() || lines.get(lines.size() - LOCATION_DIFFERENCE).equals(Line.UNCONNECTED));
    }

    public void move(final Location location) {
        checkLocation(location);
        if (moveInEnds(location)) {
            return;
        }
        if (judgeRight(location)) {
            return;
        }
        judgeLeft(location);
    }

    private boolean moveInEnds(final Location location) {
        if (location.getHorizon() == 0) {
            judgeRight(location);
            return true;
        }
        if (location.getHorizon() == lines.size()) {
            judgeLeft(location);
            return true;
        }
        return false;
    }

    private boolean judgeRight(final Location location) {
        if (findRightLines(location).equals(Line.CONNECTED)) {
            location.goRight();
            return true;
        }
        return false;
    }

    private void judgeLeft(final Location location) {
        if (findLeftLines(location).equals(Line.CONNECTED)) {
            location.goLeft();
        }
    }

    private Line findRightLines(final Location location) {
        return lines.get(location.getHorizon());
    }

    private Line findLeftLines(final Location location) {
        return lines.get(location.getHorizon() - LOCATION_DIFFERENCE);
    }

    private void checkLocation(final Location location) {
        if (location.getHorizon() > lines.size()) {
            throw new IllegalArgumentException(LOCATION_NOT_EXIST);
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
