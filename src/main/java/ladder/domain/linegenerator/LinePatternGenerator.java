package ladder.domain.linegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.Stick;

public class LinePatternGenerator implements LineGenerator {

    private static final int MIN_LINE_SIZE = 2;
    private final BooleanSupplier supplier;

    public LinePatternGenerator(BooleanSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public List<Stick> generate(int size) {
        validate(size);
        List<Stick> line = new ArrayList<>();

        while (line.size() < size - 1) {
            add(line);
        }
        return line;
    }

    private void add(List<Stick> line) {
        if (isNotOverlapped(line)) {
            line.add(generateStick());
            return;
        }
        line.add(Stick.NON_EXISTENCE);
    }

    private boolean isNotOverlapped(List<Stick> line) {
        return line.isEmpty() || !line.get(line.size() - 1).isExist();
    }

    private void validate(int size) {
        if (size < MIN_LINE_SIZE) {
            throw new IllegalArgumentException("사다리의 크기는 2 이상입니다");
        }
    }

    public Stick generateStick() {
        if (supplier.getAsBoolean()) {
            return Stick.EXISTENCE;
        }
        return Stick.NON_EXISTENCE;
    }
}
