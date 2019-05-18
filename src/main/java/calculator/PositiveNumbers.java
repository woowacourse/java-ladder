package calculator;

import java.util.List;

public class PositiveNumbers {
    private final List<Positive> positives;

    public PositiveNumbers(List<Positive> positives) {
        this.positives = positives;
    }

    public Positive sum() {
        return new Positive(positives.stream().mapToInt(Positive::getNumber).sum());
    }
}
