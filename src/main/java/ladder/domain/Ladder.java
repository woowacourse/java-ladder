package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void connect(int lineNumber, int point) { // 사다리 연결 가능한 위치에 랜덤넘버 보내서 그리게 함
        lines.get(lineNumber).connect(point);
    }

    public Line getLine(int lineNumber) {
        return lines.get(lineNumber);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getNumberOfPeople() {
        return lines.get(0).getNumberOfPeople();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
