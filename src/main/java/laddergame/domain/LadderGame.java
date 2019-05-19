package laddergame.domain;

import laddergame.controller.LadderGenerator;
import laddergame.controller.rule.Rule;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Tags members;
    private final Tags prizes;
    private final Ladder ladder;

    public LadderGame(Tags members, Tags prizes, int height, Rule rule) {
        this.members = members;
        this.prizes = prizes;
        this.ladder = LadderGenerator.generateLadder(height, members.size(), rule);
    }

    public LadderGame(Tags members, Tags prizes, Rule rule, int height) {
        this.members = members;
        this.prizes = prizes;
        this.ladder = LadderGenerator.generateLadder(height, members.size(), rule);
    }

    public LadderGameResult startGame() {
        Map<Tag, Tag> result = new HashMap<>();

        for (int i = 0; i < members.size(); i++) {
            result.put(members.getTag(i), prizes.getTag(ladder.takeLadder(i)));
        }
        return new LadderGameResult(result);
    }

    public Tags getMembers() {
        return members;
    }

    public Tags getPrizes() {
        return prizes;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
