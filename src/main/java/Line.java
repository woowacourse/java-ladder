import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int maxSize;
    private final List<Boolean> points;

    public Line(int participantsSize) {
        this.maxSize = participantsSize - 1;
        this.points = new ArrayList<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
