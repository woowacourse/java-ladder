package ladder.dto;

import ladder.model.LadderPath;
import ladder.model.Line;

import java.util.List;
import java.util.stream.IntStream;

public class LineDto {
    private final List<Boolean> connected;

    private LineDto(List<Boolean> connected) {
        this.connected = connected;
    }

    public static LineDto from(Line line) {
        List<LadderPath> row = line.getRow();
        List<Boolean> connected = IntStream.range(0, row.size() - 1)
                .mapToObj(idx -> row.get(idx).equals(LadderPath.RIGHT))
                .toList();

        return new LineDto(connected);
    }

    public List<Boolean> getConnected() {
        return connected;
    }
}
