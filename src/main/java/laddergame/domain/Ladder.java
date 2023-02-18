package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static laddergame.utils.RetryUtils.retryOnRuntimeException;

public class Ladder {
    private final Participants participants;
    private final Height height;

    private final BooleanGenerator booleanGenerator;
    private List<Line> lines;

    public Ladder(final Participants participants, final Height height, final BooleanGenerator booleanGenerator) {
        validateNotNull(participants, height, booleanGenerator);
        this.participants = participants;
        this.height = height;
        this.booleanGenerator = booleanGenerator;
        createLines();
    }

    private void validateNotNull(final Participants participants, final Height height, final BooleanGenerator booleanGenerator) {
        if (Objects.isNull(participants)) {
            throw new IllegalArgumentException("참여자는 null이 될 수 없습니다.");
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
        for (int count = 0; count < height.getValue(); count++) {
            final Line line = retryOnRuntimeException(() -> createLine(participants.getSize() - 1));
            lines.add(line);
        }
    }

    private Line createLine(final int width) {
        final List<Boolean> points = new ArrayList<>();
        for (int count = 0; count < width; count++) {
            points.add(booleanGenerator.generate());
        }

        return new Line(points);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
