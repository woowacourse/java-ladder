package ladder.domain.linegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import ladder.domain.Stick;

public class LinePatternGenerator {

    private static final int MIN_LINE_SIZE = 2;
    private final IntSupplier supplier;

    public LinePatternGenerator(IntSupplier supplier) {
        this.supplier = supplier;
    }

    public List<Stick> generate(int size) {
        validate(size);
        List<Stick> line = new ArrayList<>();

        while (line.size() < size - 1) {
            add(line);
        }
        return line;
    }

    private void add(List<Stick> line) {
        if (line.isEmpty()) {
            line.add(generateStick());
            return;
        }
        if (line.get(line.size() - 1) == Stick.EXISTENCE) {
            line.add(Stick.NON_EXISTENCE);
            return;
        }
        line.add(generateStick());
    }

    private void validate(int size) {
        if (size < MIN_LINE_SIZE) {
            throw new IllegalArgumentException("사다리의 크기는 2 이상입니다");
        }
    }

    public Stick generateStick() {
        return supplier.getAsInt() == 0 ? Stick.NON_EXISTENCE : Stick.EXISTENCE;
    }
}
