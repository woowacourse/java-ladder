package laddergame.model.generator;

import java.util.List;
import laddergame.model.laddergame.LadderHeight;
import laddergame.model.participants.Participants;

@FunctionalInterface
public interface BooleansGenerator {
    List<List<Boolean>> generate(LadderHeight ladderHeight, Participants participants);
}
