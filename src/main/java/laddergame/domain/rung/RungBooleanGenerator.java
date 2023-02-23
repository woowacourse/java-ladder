package laddergame.domain.rung;

import laddergame.util.BooleanGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RungBooleanGenerator implements BooleanGenerator {

    @Override
    public boolean generate() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
