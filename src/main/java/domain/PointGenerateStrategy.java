package domain;

@FunctionalInterface
public interface PointGenerateStrategy {

    Point generate(Point previousPoint);
}
