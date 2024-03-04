package dto;

import java.util.List;
import model.line.Line;

public record LineDto(List<Boolean> lineInfo) {
    public static LineDto from(final Line line) {
        final List<Boolean> lineInfo = line.getExistFlags();
        return new LineDto(lineInfo);
    }
}
