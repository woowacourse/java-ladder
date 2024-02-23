package domain.line;

import domain.BooleanGenerator;

import java.util.List;

public interface Points {
    List<Point> value(BooleanGenerator generator);
}
