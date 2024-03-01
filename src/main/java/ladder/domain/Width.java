package ladder.domain;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public record Width<L>(int value) {
    public List<L> repeat(Supplier<L> supplier) {
        return IntStream.range(0, value)
                .mapToObj(i -> supplier.get())
                .toList();
    }

    public void repeat(IntConsumer consumer) {
        IntStream.range(0, value).forEach(consumer);
    }
}
