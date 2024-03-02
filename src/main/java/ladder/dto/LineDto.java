package ladder.dto;

import ladder.model.Ladder;
import ladder.model.Line;

import java.util.List;

public class LineDto {
    private final List<Boolean> connected;

    private LineDto(List<Boolean> connected) {
        this.connected = connected;
    }

    public static LineDto from(Line line) {
        return new LineDto(line.getConnected());
    }

    public static List<LineDto> asList(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(LineDto::from)
                .toList();
    }

    public List<Boolean> getConnected() {
        return connected;
    }
}
