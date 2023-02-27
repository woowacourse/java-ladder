package domain.ladder;

import dto.ladder.LineDto;
import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private final List<LineDto> lines;
    private final Height height;

    public Ladder(int width, Height height, BooleanGenerator booleanGenerator) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            this.lines.add(LineDto.from(new Line(width, booleanGenerator)));
        }
        this.height = height;
    }

    public List<LineDto> getLines() {
        return lines;
    }
}
