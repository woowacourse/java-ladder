package laddergame.domain.strategy;

import laddergame.domain.Zone;

import java.util.List;

public interface LineBuildStrategy {
    List<Zone> apply(int count);
}

