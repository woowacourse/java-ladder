package ladder.domain;

@FunctionalInterface
public interface PositionCreator {
    Position create(Position position);
}
