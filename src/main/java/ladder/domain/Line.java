package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.constant.ErrorMessage.CONTINUE_SCAFFOLD;

public record Line(List<Boolean> scaffolds) {
    public Line(List<Boolean> scaffolds) {
        this.scaffolds = new ArrayList<>(scaffolds);
        validateNonContinuousHorizontal(this.scaffolds);
    }

    private static void validateNonContinuousHorizontal(List<Boolean> scaffolds) {
        if (IntStream.range(0, scaffolds.size() - 1)
                .anyMatch(i -> scaffolds.get(i) && scaffolds.get(i + 1))) {
            throw new IllegalArgumentException(CONTINUE_SCAFFOLD.generate());
        }
    }

    @Override
    public List<Boolean> scaffolds() {
        return List.copyOf(scaffolds);
    }
}
