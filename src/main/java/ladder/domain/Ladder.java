package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        checkZero(lines.size());
        this.lines = lines;
    }

    private void checkZero(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }

    List<Record> drawLadder(List<Record> log) {
        Record last = log.get(0);
        for (Line line : lines) {
            Record newRecord = line.drawLine(last);
            log.add(newRecord);
            last = newRecord;
        }
        return log;
    }

    @Override
    public String toString() {
        return this.lines.stream().map(line -> line.toString()).collect(Collectors.joining("\n"));
    }
}
