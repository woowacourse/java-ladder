package domain;

public interface PointGenerator {
    Point generate();

    Point generateExceptLeft();

    Point generateExceptRight();
}
