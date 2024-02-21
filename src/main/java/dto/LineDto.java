package dto;

import java.util.List;
import model.Line;

public record LineDto(List<Boolean> paths) {
    public static LineDto from(Line line) {
        return new LineDto(line.getPaths());
    }
}
