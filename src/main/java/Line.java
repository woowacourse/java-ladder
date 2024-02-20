import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int maxSize;
    private final List<Boolean> points;

    public Line(int participantsSize) {
        this.maxSize = participantsSize - 1;
        this.points = new ArrayList<>();
    }


    public void cross(boolean existPoint) {
        if (points.size() == maxSize - 1 && existPoint) {
            points.add(existPoint);
            return;
        }
        points.add(existPoint);
        if (existPoint) {
            points.add(!existPoint);
        }
    }

    public int size() {
        return points.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
