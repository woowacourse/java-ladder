package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class Line {
    private final List<Boolean> scaffold;

    public Line(List<Boolean> scaffold) {
        this.scaffold = new ArrayList<>(scaffold);
    }

    public static Line create(IntFunction<List<Boolean>> generator, int count) {
        return new Line(generator.apply(count));
    }
}
