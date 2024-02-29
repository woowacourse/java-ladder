package laddergame.util;

import laddergame.domain.Rung;
import laddergame.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomLinesGenerator implements LinesGenerator {

    private final Random random;

    public RandomLinesGenerator() {
        this.random = new Random();
    }

    @Override
    public Line generate(final int width) {
        List<Rung> rungStatuses = new ArrayList<>();

        rungStatuses.add(randomSelectLine());
        for (int i = 0; i < width - 1; i++) {
            Rung beforeValue = rungStatuses.get(rungStatuses.size() -1);
            rungStatuses.add(decideNextValue(beforeValue));
        }
        return new Line(rungStatuses);
    }

    private Rung randomSelectLine() {
        List<Rung> rungs = Arrays.stream(Rung.values()).toList();
        int randomIndex = random.nextInt(rungs.size());

        return rungs.get(randomIndex);
    }

    private Rung decideNextValue(Rung beforeValue) {
        if (beforeValue.equals(Rung.BRIDGE)) {
            return Rung.EMPTY;
        }
        return randomSelectLine();
    }
}
