package domain.line;

import static domain.connection.Connection.DISCONNECTION;

import domain.ColumnPosition;
import domain.connection.Connection;
import domain.connection.ConnectionGenerator;
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
