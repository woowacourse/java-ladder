package laddergame.model.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import laddergame.model.participants.Participants;

public class RandomDoublyBooleanListGenerator {
    private final Random random = new Random();

    public List<List<Boolean>> generate(LadderHeight ladderHeight, Participants participants) {
        List<List<Boolean>> doubleBooleans = new ArrayList<>();
        for (int i = 0; i < ladderHeight.height(); i++) {
            doubleBooleans.add(generateBooleans(participants.getSize()));
        }
        return doubleBooleans;
    }

    private List<Boolean> generateBooleans(int size) {
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            booleans.add(random.nextBoolean());
        }
        return booleans;
    }
}
