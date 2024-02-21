package ladder.dto;

import ladder.constant.LadderPath;
import ladder.model.Line;

import java.util.List;

public class LineDto {
    List<Boolean> connected;

    private LineDto(List<Boolean> connected) {
        this.connected = connected;
    }

    public static LineDto from(Line line) {
        List<Boolean> tmpConnected;

        // TODO: 마지막 요소 삭제 로직 개선
        List<LadderPath> tmpRow = line.getRow();
        tmpRow.remove(tmpRow.size() - 1);

        tmpConnected = tmpRow.stream()
                .map(p -> p.equals(LadderPath.RIGHT))
                .toList();

        return new LineDto(tmpConnected);
    }

    public List<Boolean> getConnected() {
        return connected;
    }
}
