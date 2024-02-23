package domain.line;

import domain.BooleanGenerator;

import java.util.List;

public interface LineValue {
    List<Point> value(BooleanGenerator generator);
}
