package laddergame.domain.strategy;

import laddergame.dto.LineBuildResult;

public interface CanBuildStrategy {
    LineBuildResult canBuildBridges(int count);
}

