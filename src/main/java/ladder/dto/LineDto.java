package ladder.dto;

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

    public List<Boolean> getConnected() {
        return connected;
    }
}
