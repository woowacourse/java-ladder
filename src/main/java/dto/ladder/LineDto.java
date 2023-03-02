package dto.ladder;

import domain.ladder.Line;
import java.util.List;

public class LineDto {
    private final List<Boolean> line;

    private LineDto(List<Boolean> line) {
        this.line = line;
    }

    public static LineDto from(Line line) {
        return new LineDto(line.getLine());
    }

    public List<Boolean> getLine() {
        return line;
    }
}
