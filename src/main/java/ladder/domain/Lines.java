package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.dto.LinesDto;

public class Lines {

    public static final int USEFUL_INDEX_START = 1;
    private final List<Line> lines;
    private final Height height;

    public Lines(int height, int lineCount) {
        this.height = new Height(height);
        lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            lines.add(new Line(this.height));
        }
    }

    public void generateLegsOfLines(Generator generator) {
        IntStream.range(1, lines.size())
                .forEach(i -> generateLegsOfLine(generator, i));
    }

    private void generateLegsOfLine(Generator generator, int columnIndex) {
        for (int rowIndex = 0; rowIndex < height.getHeight(); rowIndex++) {
            connectLegs(generator, columnIndex, rowIndex);
        }
    }

    private void connectLegs(Generator generator, int columnIndex, int rowIndex) {
        if (shouldConnect(generator, columnIndex, rowIndex)) {
            lines.get(columnIndex).connectHeight(rowIndex);
        }
    }

    private boolean shouldConnect(Generator generator, int columnIndex, int rowIndex) {
        return generator.generate() && !lines.get(columnIndex - 1).isConnected(rowIndex);
    }

    public LinesDto toDto() {
        return new LinesDto(removeUselessLine().stream()
                .map(Line::toDto)
                .collect(Collectors.toList()), height.getHeight());
    }

    private List<Line> removeUselessLine() {
        return lines.subList(USEFUL_INDEX_START, lines.size());
    }
}
