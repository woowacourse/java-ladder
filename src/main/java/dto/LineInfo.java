package dto;

import java.util.List;
import model.Line;

public record LineInfo(List<Boolean> lineInfo) {
    public static LineInfo from(Line line) {
        List<Boolean> lineInfo = line.getLineInfo();
        return new LineInfo(lineInfo);
    }
}
