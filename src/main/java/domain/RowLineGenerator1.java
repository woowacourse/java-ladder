package domain;

import static domain.Connection.DISCONNECTION;

import java.util.ArrayList;
import java.util.List;

public class RowLineGenerator1 {
    private final ConnectionGenerator1 connectionGenerator1;

    public RowLineGenerator1(ConnectionGenerator1 connectionGenerator1) {
        this.connectionGenerator1 = connectionGenerator1;
    }

    public RowLine1 generate(int personCount) {
        Connection previous = DISCONNECTION;
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < personCount - 1; i++) {
            Connection generated = connectionGenerator1.generate(previous);
            new Point(new ColumnPosition(i), generated);
            previous = generated;
        }

        Connection generated = connectionGenerator1.generate(previous);
        points.add(new Point(new ColumnPosition(personCount - 1), generated));

        return new RowLine1(points);
    }
}
