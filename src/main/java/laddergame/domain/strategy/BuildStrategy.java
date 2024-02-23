package laddergame.domain.strategy;

import laddergame.dto.LineBuildResult;

public interface BuildStrategy {
    LineBuildResult canBuildBridges(int count);
}

