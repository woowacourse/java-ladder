import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;
    public Line(int participantSize) {
        this.points = new ArrayList<>();
        for (int i = 0; i < participantSize-1; i++) {
            points.add(false);
        }
    }

    public int size() {
        return points.size();
    }
}
