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
        validate(participants, height, booleanGenerator);
        this.participants = participants;
        this.height = height;
        this.booleanGenerator = booleanGenerator;
        createLines();
    }

    private void validate(final Participants participants, final Height height, final BooleanGenerator booleanGenerator) {
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

        int heightLength = height.getValue();

        while (heightLength-- > 0) {
            final Line line = retryOnRuntimeException(() -> createLine(participants.getSize() - 1));
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
