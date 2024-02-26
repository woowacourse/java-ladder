package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();

    private final List<Step> steps;

    /**
     * @param width
     */
    public Line(Width width) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < width.getValue() - 1; i++) {
            steps.add(s)
            steps.add(generate(steps))
            result.add(generate(result, i));
        }
        this.steps = result;
    }

    private Boolean generate(List<Boolean> points, int index) {
        if (cannotConnect(points, index)) {
            return false;
        }
        return random.nextBoolean();
    }

    private boolean cannotConnect(List<Boolean> points, int index) {
        return index >= 1 && points.get(index - 1);
    }

    public int size() {
        return steps.size();
    }

    public boolean isConnected(int index) {
        return steps.get(index);
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
