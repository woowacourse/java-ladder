package laddergame.controller;

import laddergame.controller.rule.Rule;
import laddergame.domain.Ladder;
import laddergame.domain.Tags;
import laddergame.util.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Tags members;
    private final Tags prizes;
    private final Ladder ladder;

    public LadderGame(Tags members, Rule rule) {
        this.members = members;
        this.prizes = GamePreparer.makePrizes(members.size());
        this.ladder = LadderGenerator.generateLadder(GamePreparer.makeHeight(), members.size(), rule);
    }

    public LadderGame(Tags members, Tags prizes, Rule rule, int height) {
        this.members = members;
        this.prizes = prizes;
        this.ladder = LadderGenerator.generateLadder(height, members.size(), rule);
    }

    public LadderGameResult startGame() {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < members.size(); i++) {
            result.put(members.getTagName(i), prizes.getTagName(ladder.takeLadder(i)));
        }
        OutputView.outputLadderGame(members, ladder, prizes);
        return new LadderGameResult(result);
    }
}
