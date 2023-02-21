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
            if (presentPosition == 0) {
                if (line.getConnections().get(presentPosition)) {
                    presentPosition++;
                }
            } else {
                if (presentPosition == (line.getConnections().size() - 1)) {
                    if (line.getConnections().get(presentPosition - 1)) {
                        presentPosition--;
                        continue;
                    }
                }
                if (line.getConnections().get(presentPosition - 1)) {
                    presentPosition--;
                }
                if (line.getConnections().get(presentPosition)) {
                    presentPosition++;
                }
            }
        }

        return presentPosition;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
