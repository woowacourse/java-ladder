package ladder.domain.ladder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final String NOT_NUMBER = "\\D";
    private static final Pattern CHARACTER_SET_NOT_NUMBER = Pattern.compile(NOT_NUMBER);

    private final List<Line> lines;

    public Ladder(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        this.lines = createLines(barGenerator, ladderHeight, peopleSize);
    }

    private List<Line> createLines(BarGenerator barGenerator, int ladderHeight, int peopleSize) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(lineCount -> createLine(barGenerator, peopleSize))
                .collect(Collectors.toUnmodifiableList());
    }

    private Line createLine(BarGenerator barGenerator, int peopleSize) {
        Line line = new Line();
        line.addBars(peopleSize, barGenerator);
        return line;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public static void validateNonNumber(String ladderHeight) {
        Matcher matcher = CHARACTER_SET_NOT_NUMBER.matcher(ladderHeight);
        if (matcher.find()) {
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }
}
