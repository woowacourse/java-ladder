package ladder.domain.ladder;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public record Height(int value) {
    private static final int MIN_HEIGHT = 1;

    public Height {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(
                    "높이는 %d 이상이여야 합니다: %d".formatted(MIN_HEIGHT, value)
            );
        }
    }

    public <T> List<T> repeat(Supplier<T> supplier) {
        return Stream.generate(supplier).limit(value).toList();
    }
}
