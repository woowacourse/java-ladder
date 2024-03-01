package domain;

import static domain.Connection.DISCONNECTION;

import java.util.ArrayList;
import java.util.List;

public class RowLineGenerator {

    private final ConnectionGenerator connectionGenerator;

    public RowLineGenerator(ConnectionGenerator connectionGenerator) {
        this.connectionGenerator = connectionGenerator;
    }

    public RowLine generate(int personCount) {
        Connection previous = DISCONNECTION;
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            Connection generated = connectionGenerator.generate(previous);
            points.add(new Point(new ColumnPosition(i), generated));
            previous = generated;
        }

        Connection generated = connectionGenerator.generateLastConnection(previous);
        points.add(new Point(new ColumnPosition(personCount - 1), generated));
        return new RowLine(points);
    }
}
