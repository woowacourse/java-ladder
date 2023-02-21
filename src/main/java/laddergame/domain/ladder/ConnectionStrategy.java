package laddergame.domain.ladder;

@FunctionalInterface
public interface ConnectionStrategy {

    Connection connect();
}
