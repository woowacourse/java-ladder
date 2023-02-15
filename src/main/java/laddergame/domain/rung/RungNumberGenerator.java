package laddergame.domain.rung;

import laddergame.util.NumberGenerator;

import java.util.concurrent.ThreadLocalRandom;

import static laddergame.domain.rung.Rung.INSUFFICIENT;
import static laddergame.domain.rung.Rung.SUFFICIENT;

public class RungNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return INSUFFICIENT + ThreadLocalRandom.current().nextInt(SUFFICIENT - INSUFFICIENT + 1);
    }
}
