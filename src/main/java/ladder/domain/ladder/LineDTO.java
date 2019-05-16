package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LineDTO {
    private List<Boolean> points = new ArrayList<>();

    public LineDTO(List<Boolean> points){
        this.points = points;
    }

    public LineDTO(Line line){
        this(line.getPoints());
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
