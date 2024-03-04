package laddergame.model.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import laddergame.model.laddergame.LadderHeight;
import laddergame.model.laddergame.LineConnectionDecision;
import laddergame.model.participants.Participants;

public class RandomLineConnectionDecisionGenerator implements LineConnectionDecisionGenerator {
    private final Random random = new Random();

    @Override
    public List<List<LineConnectionDecision>> generate(LadderHeight ladderHeight, Participants participants) {
        List<List<LineConnectionDecision>> doubleBooleans = new ArrayList<>();
        for (int i = 0; i < ladderHeight.height(); i++) {
            doubleBooleans.add(generateBooleans(participants.getSize()));
        }
        return doubleBooleans;
    }

    private List<LineConnectionDecision> generateBooleans(int size) {
        List<LineConnectionDecision> booleans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            booleans.add(new LineConnectionDecision(random.nextBoolean()));
        }
        return booleans;
    }
}
