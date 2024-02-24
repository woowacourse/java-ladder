package laddergame.domain.strategy;

import java.util.List;

public interface LineBuildStrategy {
    List<Boolean> apply(int count);
}

