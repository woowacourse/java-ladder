package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.dto.LinesDto;

public class Lines {

    private final List<Line> lines;
    private final Height height;

    public Lines(int height, int lineCount) {
        this.height = new Height(height);
        lines = new ArrayList<>();
        for (int i = 0; i < lineCount + 1; i++) {
            lines.add(new Line(this.height));
        }
    }

    public void generateLegsOfLines(Generator generator) {
        IntStream.range(1, lines.size() - 1)
                .forEach(i -> generateLegsOfLine(generator, i));
    }

    private void generateLegsOfLine(Generator generator, int lineIndex) {
        for (int heightIndex = 0; heightIndex < height.getHeight(); heightIndex++) {
            connectLegs(generator, lineIndex, heightIndex);
        }
    }

    private void connectLegs(Generator generator, int lineIndex, int heightIndex) {
        if (shouldConnect(generator, lineIndex, heightIndex)) {
            lines.get(lineIndex).connectHeight(heightIndex);
        }
    }

    private boolean shouldConnect(Generator generator, int lineIndex, int heightIndex) {
        return generator.generate() && !lines.get(lineIndex - 1).getByHeight(heightIndex);
    }

    public LinesDto toDto() {
        return new LinesDto(removeMeaninglessLine().stream()
                .map(Line::toDto)
                .collect(Collectors.toList()), height.getHeight());
    }

    private List<Line> removeMeaninglessLine() {
        return lines.subList(1, lines.size() - 1);
    }
}
