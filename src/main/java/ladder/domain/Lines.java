package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;
    private final Height height;

    public Lines(int height, int lineCount) {
        this.height = new Height(height);
        lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            lines.add(new Line(this.height));
        }
    }

    public void generate(Generator generator) {
        for (int i = 0; i < height.getH(); i++) {

        }
    }
}
