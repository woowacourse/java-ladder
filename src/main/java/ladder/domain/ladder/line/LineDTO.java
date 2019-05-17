package ladder.domain.ladder.line;

import java.util.List;

public class LineDTO {
    private List<Boolean> points;

    public LineDTO(List<Boolean> points) {
        this.points = points;
    }

    public LineDTO(Line line) {
        this(line.getPoints());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
