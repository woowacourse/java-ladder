package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.dto.LinesDto;

public class Lines {

    private final List<Line> lines;
    private final Height height;

    public Lines(int height, int width) {
        this.height = new Height(height);
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
    }

    public void generateLegsOfLines(Generator generator) {
        lines.forEach(line -> line.generateRandom(generator));
    }

    public LinesDto toDto() {
        return new LinesDto(lines.stream()
                .map(Line::toDto)
                .collect(Collectors.toList()), height.getHeight());
    }
}
