package domain.ladder;

public class Point {
    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point1 = (Point) o;

        return point != point1.point;
    }

    @Override
    public int hashCode() {
        return (point ? 1 : 0);
    }

    public boolean isPoint() {
        return point;
    }

    public Point nonPass() {
        return new Point(false);
    }
}
