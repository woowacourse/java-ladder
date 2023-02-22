package domain.model;

import domain.type.Line;
import domain.vo.Location;
import java.util.List;

public class Layer {

    private static final String LOCATION_NOT_EXIST = "층에 존재하지 않는 위치입니다.";
    private static final int LOCATION_DIFFERENCE = 1;
    private final List<Line> lines;
    private final PassGenerator passGenerator;

    public Layer(final List<Line> lines, final PassGenerator passGenerator) {
        this.lines = lines;
        this.passGenerator = passGenerator;
    }

    public void makeLine() {
        if (passGenerator.generate()
            && (lines.isEmpty() || lines.get(lines.size() - LOCATION_DIFFERENCE)
            .equals(Line.UNCONNECTED))) {
            lines.add(Line.CONNECTED);
            return;
        }
        lines.add(Line.UNCONNECTED);
    }

    public void move(final Location location) {
        checkLocation(location);
        location.goDown();
        if (moveInEnds(location)) {
            return;
        }
        judgeRight(location);
        judgeLeft(location);
    }

    private boolean moveInEnds(Location location) {
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

    private void judgeRight(Location location) {
        if (findRightLines(location).equals(Line.CONNECTED)) {
            location.goRight();
        }
    }

    private void judgeLeft(Location location) {
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

    private void checkLocation(Location location) {
        if (location.getHorizon() > lines.size()) {
            throw new IllegalArgumentException(LOCATION_NOT_EXIST);
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
