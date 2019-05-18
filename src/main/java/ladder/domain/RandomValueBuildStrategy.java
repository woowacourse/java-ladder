package ladder.domain;

import ladder.utils.RandomValueUtils;

public class RandomValueBuildStrategy implements LadderBuildingStrategy {
    @Override
    public boolean generate() {
        return RandomValueUtils.generate();
    }
}
