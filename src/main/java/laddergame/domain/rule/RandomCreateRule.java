package laddergame.domain.rule;

import java.util.Random;

public class RandomCreateRule implements Rule {
    @Override
    public boolean canCreate() {
        return new Random().nextBoolean();
    }
}
