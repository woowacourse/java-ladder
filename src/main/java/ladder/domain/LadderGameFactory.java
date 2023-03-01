package ladder.domain;

import ladder.domain.ladderNode.Players;
import ladder.domain.ladderNode.Results;
import ladder.utils.LineStrategy;

import java.util.List;

public class LadderGameFactory {
    private final LineStrategy lineStrategy;

    public LadderGameFactory(LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
    }

    public LadderGame generateGame(List<String> names, List<String> inputResults, int height) {
        Players players = new Players(names);
        Ladder ladder = new Ladder(names.size(), height, lineStrategy);
        Results result = new Results(inputResults, players.size());
        return LadderGame.of(ladder, players, result);
    }
}
