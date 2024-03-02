package laddergame.util;

import laddergame.domain.Rung;
import laddergame.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomRungGenerator implements RungGenerator {

    private final Random random;

    public RandomRungGenerator() {
        this.random = new Random();
    }

    @Override
    public Rung generate() {
        List<Rung> rungs = Arrays.stream(Rung.values()).toList();
        int randomIndex = random.nextInt(rungs.size());

        return rungs.get(randomIndex);
    }
}
