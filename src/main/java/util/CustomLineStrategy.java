package util;

import domain.Line;
import domain.Step;
import java.util.List;

public class CustomLineStrategy implements LineStrategy {

    private final List<Step> steps;
    private int index;

    public CustomLineStrategy(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public Line generate(int width) {
        return null;
    }
}
