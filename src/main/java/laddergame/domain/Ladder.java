package laddergame.domain;

import static laddergame.utils.RetryUtils.retryOnRuntimeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final Width width;
    private final Height height;
    private final BooleanGenerator booleanGenerator;

    private List<Line> lines;

    public Ladder(final Width width, final Height height, final BooleanGenerator booleanGenerator) {
        validate(width, height, booleanGenerator);
        this.width = width;
        this.height = height;
        this.booleanGenerator = booleanGenerator;
        createLines();
    }

    private void validate(final Width width, final Height height, final BooleanGenerator booleanGenerator) {
        if (Objects.isNull(width)) {
            throw new IllegalArgumentException("너비는 null이 될 수 없습니다.");
        }
        if (Objects.isNull(height)) {
            throw new IllegalArgumentException("높이는 null이 될 수 없습니다.");
        }
        if (Objects.isNull(booleanGenerator)) {
            throw new IllegalArgumentException("boolean 생성기는 null이 될 수 없습니다.");
        }
    }

    public void createLines() {
        lines = new ArrayList<>();

        int heightLength = height.getValue();

        while (heightLength-- > 0) {
            final Line line = retryOnRuntimeException(() -> createLine(width.getValue() - 1));
            lines.add(line);
        }
    }

    private Line createLine(int width) {
        final List<Boolean> points = new ArrayList<>();
        while (width-- > 0) {
            points.add(booleanGenerator.generate());
        }

        return new Line(points);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
