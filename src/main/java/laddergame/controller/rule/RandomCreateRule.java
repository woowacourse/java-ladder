package laddergame.controller.rule;

import laddergame.util.RandomGenerator;

public class RandomCreateRule implements Rule {
    @Override
    public boolean canCreate() {
        return RandomGenerator.makeTrueOrFalse();
    }
}
