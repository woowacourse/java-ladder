package laddergame.model.participants;

import laddergame.model.laddergame.LadderGame;

public record IndexInfo(Participant participant, int index) {

    public IndexInfo getUpdatedIndexInfo(LadderGame ladderGame) {
        return new IndexInfo(participant, ladderGame.climb(index));
    }
}
