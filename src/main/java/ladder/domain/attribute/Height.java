package ladder.domain.attribute;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public record Height<L>(int value) {

    private static final int MIN_HEIGHT = 1;

    public Height {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("자연수를 입력해주세요: %d".formatted(value));
        }
    }

    public List<L> repeat(final Supplier<L> supplier) {
        return IntStream.range(0, value)
                .mapToObj(__ -> supplier.get())
                .toList();
    }
}
