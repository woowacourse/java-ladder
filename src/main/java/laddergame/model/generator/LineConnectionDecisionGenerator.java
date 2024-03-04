package laddergame.model.generator;

import java.util.List;
import laddergame.model.laddergame.LadderHeight;
import laddergame.model.laddergame.LineConnectionDecision;
import laddergame.model.participants.Participants;

@FunctionalInterface
public interface LineConnectionDecisionGenerator {
    List<List<LineConnectionDecision>> generate(LadderHeight ladderHeight, Participants participants);
}
