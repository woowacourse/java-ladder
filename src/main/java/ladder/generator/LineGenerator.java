package ladder.generator;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class LineGenerator {

    private static final Random random = new Random();

    Line makeLine(int countOfPlayers) {
        return new Line(makeRandomBooleans(countOfPlayers - 1));
    }

    private List<Boolean> makeRandomBooleans(int length) {
        List<Boolean> randomBooleanList = new ArrayList<>();

        randomBooleanList.add(random.nextBoolean());

        for (int i = 1; i < length; i++) {
            randomBooleanList.add(getNextBoolean(randomBooleanList.get(i - 1)));
        }

        return randomBooleanList;
    }

    private boolean getNextBoolean(boolean before) {
        return !before && new Random().nextBoolean();
    }
}
