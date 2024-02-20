package domain;

import java.util.ArrayList;
import java.util.List;

public class LinesFactory {
    private final int height;
    private final PointFactory pointFactory;

    public LinesFactory(int height, int playerCount, NumberGenerator randomNumberGenerator) {
        this.height = height;
        this.pointFactory = new PointFactory(randomNumberGenerator, playerCount);
    }

    public List<Line> generateLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(pointFactory.generatePoints());
        }
        return lines;
    }
}
