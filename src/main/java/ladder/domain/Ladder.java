package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String NEXT_LINE = "\n";
    private static final int MINIMUM_COUNT_OF_LINES = 1;
    private static final int FIRST_RECORD = 0;

    private List<Line> lines;
    private List<Record> log;

    public Ladder(List<Line> lines) {
        checkZero(lines.size());
        this.lines = lines;
        initLog(lines.get(0).length() + 1);
    }

    private void checkZero(int count) {
        if (count < MINIMUM_COUNT_OF_LINES) {
            throw new IllegalArgumentException();
        }
    }

    private void initLog(int sizeOfRecord) {
        log = new ArrayList<>();
        Record init_record = new Record(Arrays.stream(IntStream.rangeClosed(0, sizeOfRecord - 1)
                .toArray())
                .boxed()
                .collect(Collectors.toList()));
        log.add(init_record);
    }

    List<Record> drawLadder(List<Record> log) {
        Record last = log.get(FIRST_RECORD);
        for (Line line : lines) {
            Record newRecord = line.drawLine(last);
            log.add(newRecord);
            last = newRecord;
        }
        return log;
    }



    @Override
    public String toString() {
        return this.lines.stream().map(Line::toString).collect(Collectors.joining(NEXT_LINE));
    }
}
