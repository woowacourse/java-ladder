package ladderGame.domain;

import java.util.*;

public class Floor {
    private final List<Point> points = new ArrayList<>();

    public Floor() {}

    public Floor(int width) {
        makePoints(createState(width - 1));
    }

    void makePoints(List<Boolean> states) {
        points.add(Point.pointFirst(states.get(0)));
        for (int i = 1; i < states.size(); i++) {
            Point prePoint = points.get(points.size() - 1);
            points.add(prePoint.nextPoint(states.get(i)));
        }
        points.add(points.get(points.size() - 1).nextPointLast());
    }

    private List<Boolean> createState(int stateSize) {
        List<Boolean> states = new ArrayList<>();

        states.add(makeBoolean());
        while (states.size() != stateSize) {
            states.add(checkStates(states));
        }
        return states;
    }

    private boolean checkStates(List<Boolean> states) {
        if (states.get(states.size() - 1)) {
            return false;
        }
        return makeBoolean();
    }

    private boolean makeBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public Point getPointByPosition(int position) {
        return points.get(position);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(points, floor.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
