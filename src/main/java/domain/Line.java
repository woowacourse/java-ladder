package domain;

public class Line {

    public static final int POINT_MIN_SIZE = 1;
    public static final int POINT_MAX_SIZE = 20;
    
    public Line(int pointSize) {
        validate(pointSize);
    }

    private void validate(int pointSize) {
        if (pointSize < POINT_MIN_SIZE || pointSize > POINT_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
