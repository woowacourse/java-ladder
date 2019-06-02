package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(int userSize, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LineGenerator.generate(userSize));
        }
        return new Ladder(lines);
    }
}
