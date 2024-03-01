package ladder.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public record Height<L>(int value) {

    private static final int MIN_HEIGHT = 1;

    public Height {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 %d이상입니다.".formatted(MIN_HEIGHT));
        }
    }

    public List<L> repeat(Supplier<L> supplier) {
        return IntStream.range(0, value)
                .mapToObj(__ -> supplier.get())
                .toList();
    }
}
