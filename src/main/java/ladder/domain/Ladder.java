package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.linegenerator.StickListGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, int countOfPlayers, StickListGenerator stickListGenerator) {
        List<Line> generateLine = IntStream.range(0, height.getValue())
                .mapToObj(index -> new Line(stickListGenerator.generate(countOfPlayers)))
                .toList();
        return new Ladder(generateLine);
    }

    public boolean isExist(int height, int width) {
        if (height < 0 || height >= getHeight()) {
            throw new IllegalArgumentException("높이 위치가 범위를 벗어났습니다.");
        }
        return lines.get(height).isExist(width);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).getWidth();
    }
}
