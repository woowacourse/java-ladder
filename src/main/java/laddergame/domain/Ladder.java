package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Participants participants;
    private final Height height;

    public Ladder(final Participants participants, final Height height) {
        if (participants == null) {
            throw new IllegalArgumentException();
        }
        if (height == null) {
            throw new IllegalArgumentException();
        }
        this.participants = participants;
        this.height = height;
    }

    public List<Line> createLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            // TODO : 라인 랜덤 값 생성
            lines.add(new Line(List.of(true, false, false)));
        }
        return lines;
    }
}
