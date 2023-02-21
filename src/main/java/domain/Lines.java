package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.generator.ConnectionGenerator;

public class Lines {

    private final List<Line> lines;

    public Lines(final int numberOfPlayer, final int height, final ConnectionGenerator connectionGenerator) {
        this.lines = makeLines(numberOfPlayer, height, connectionGenerator);
    }

    private List<Line> makeLines(final int numberOfPlayer, final int height,
                                 final ConnectionGenerator connectionGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, connectionGenerator));
        }

        return lines;
    }

    public int goDown(final int namePosition) {
        int presentPosition = namePosition;

        for (Line line : this.lines) {
            presentPosition = moveWhenLeftMost(presentPosition, line);
            presentPosition = moveInGeneral(presentPosition, line);
            presentPosition = moveWhenRightMost(presentPosition, line);
        }

        return presentPosition;
    }

    private int moveWhenLeftMost(int presentPosition, final Line line) {
        if (presentPosition == 0) {
            presentPosition = moveRightWhenConnectionExist(line, presentPosition);
        }
        return presentPosition;
    }

    private int moveInGeneral(int presentPosition, final Line line) {
        if (presentPosition > 0 && presentPosition < (line.getConnections().size() - 1)) {
            presentPosition = moveLeftWhenConnectionExist(line, presentPosition);
            presentPosition = moveRightWhenConnectionExist(line, presentPosition);
        }
        return presentPosition;
    }

    private int moveWhenRightMost(int presentPosition, final Line line) {
        if (presentPosition == (line.getConnections().size() - 1)) {
            presentPosition = moveLeftWhenConnectionExist(line, presentPosition);
        }
        return presentPosition;
    }

    private int moveLeftWhenConnectionExist(final Line line, int presentPosition) {
        if (line.getConnections().get(presentPosition - 1)) {
            presentPosition--;
        }
        return presentPosition;
    }

    private int moveRightWhenConnectionExist(final Line line, int presentPosition) {
        if (line.getConnections().get(presentPosition)) {
            presentPosition++;
        }
        return presentPosition;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
