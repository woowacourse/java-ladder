package domain.ladder.sticks;

import domain.ladder.stick.Stick;
import domain.ladder.stick.StickGenerator;

import java.util.ArrayList;
import java.util.List;

public class NotRepeatedSticksGenerator implements SticksGenerator {

    private List<Stick> sticks;
    private final StickGenerator stickGenerator;

    public NotRepeatedSticksGenerator(StickGenerator stickGenerator) {
        this.stickGenerator = stickGenerator;
    }

    @Override
    public List<Stick> generate(int stickCount) {
        this.sticks = new ArrayList<>();
        for (int i = 0; i < stickCount; i++) {
            this.sticks.add(generateOne(stickGenerator));
        }

        return this.sticks;
    }

    private Stick generateOne(StickGenerator stickGenerator) {
        Stick generatedStick = stickGenerator.generateOne();
        if (isRepeatedFilledStick(generatedStick)) {
            generatedStick = generatedStick.getOpposite();
        }

        return generatedStick;
    }

    private boolean isRepeatedFilledStick(Stick stick) {
        if (this.sticks.isEmpty()) {
            return false;
        }

        return stick.isFilled() && isRepeat(stick);
    }

    private boolean isRepeat(Stick stick) {
        Stick lastStick = this.sticks.get(this.sticks.size() - 1);

        return lastStick.isSameType(stick);
    }
}
