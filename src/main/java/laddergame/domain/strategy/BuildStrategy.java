package laddergame.domain.strategy;

import laddergame.domain.Points;

@FunctionalInterface
public interface BuildStrategy {
    Points build(int count);
}

