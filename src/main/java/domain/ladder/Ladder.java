package domain.ladder;

import dto.ladder.LineDto;
import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int width, Height height, BooleanGenerator booleanGenerator) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            this.lines.add(new Line(width, booleanGenerator));
        }
    }

    public List<LineDto> getLines() {
        List<LineDto> lineDtos = new ArrayList<>();
        for (Line line : lines) {
            lineDtos.add(LineDto.from(line));
        }
        return lineDtos;
    }
}
