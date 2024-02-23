package laddergame.domain.strategy;

import laddergame.dto.LineBuildResult;

public interface LineBuildStrategy {
    LineBuildResult apply(int count);
}

