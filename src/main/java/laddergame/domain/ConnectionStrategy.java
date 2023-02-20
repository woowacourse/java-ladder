package laddergame.domain;

@FunctionalInterface
public interface ConnectionStrategy {

    Connection connect();
}
