package laddergame.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.dto.LineBuildResult;

public class Ladder {
    private static final String NUMBER_REGEX = "^[\\d]*$";
    private final List<Line> lines;
    private final int height;

    public Ladder(final int playerCount, final String height) {
        validate(height);

        this.height = Integer.parseInt(height);
        this.lines = IntStream.range(0, this.height)
                .mapToObj(i -> new Line(playerCount))
                .collect(Collectors.toList());
    }

    private void validate(final String height) {
        checkIsNumber(height);
        checkIsZero(height);
    }

    private void checkIsNumber(final String height) {
        if (!Pattern.matches(NUMBER_REGEX, height)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsZero(final String height) {
        if (Integer.parseInt(height) == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void build(final List<LineBuildResult> isBridgesBuilt) {
        IntStream.range(0, lines.size())
                .forEach(i -> lines.get(i).buildBridge(isBridgesBuilt.get(i)));
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
