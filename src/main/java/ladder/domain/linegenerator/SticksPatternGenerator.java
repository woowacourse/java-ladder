package ladder.domain.linegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import ladder.domain.Stick;

public class SticksPatternGenerator implements StickListGenerator {

    private static final int MIN_PLAYERS = 2;

    private final BooleanSupplier booleanGenerator;

    public SticksPatternGenerator(BooleanSupplier booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    @Override
    public List<Stick> generate(int countOfPlayers) {
        validate(countOfPlayers);
        int width = countOfPlayers - 1;
        List<Stick> sticks = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            addStick(sticks);
        }
        return sticks;
    }

    private void validate(int countOfPlayers) {
        if (countOfPlayers < MIN_PLAYERS) {
            throw new IllegalArgumentException("사다리의 크기는 2 이상입니다");
        }
    }

    private void addStick(List<Stick> sticks) {
        if (isNotExistAtTheEnd(sticks)) {
            sticks.add(generateStick());
            return;
        }
        sticks.add(Stick.NON_EXISTENCE);
    }

    private boolean isNotExistAtTheEnd(List<Stick> sticks) {
        return sticks.isEmpty() || !sticks.get(sticks.size() - 1).isExist();
    }

    private Stick generateStick() {
        if (booleanGenerator.getAsBoolean()) {
            return Stick.EXISTENCE;
        }
        return Stick.NON_EXISTENCE;
    }
}
