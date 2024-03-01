package ladder.domain.attribute;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public record Width<L>(int value) {

    public List<L> repeat(final Supplier<L> supplier) {
        return IntStream.range(0, value)
                .mapToObj(i -> supplier.get())
                .toList();
    }

    public void repeat(final IntConsumer consumer) {
        IntStream.range(0, value).forEach(consumer);
    }
}
