package laddergame.domain.strategy;

import java.util.List;

public interface CanBuildStrategy {
    List<Boolean> canBuildBridges(int count);
}

