package laddergame.domain;

import laddergame.util.RandomGenerator;

public class RandomCreate implements Rule {
    @Override
    public boolean canCreate() {
        return RandomGenerator.makeTrueOrFalse();
    }
}
