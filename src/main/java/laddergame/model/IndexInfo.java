package laddergame.model;

public class IndexInfo {
    private final Participant participant;
    private final int index;

    public IndexInfo(Participant participant, int index) {
        this.participant = participant;
        this.index = index;
    }

    public IndexInfo getUpdatedIndexInfo(LadderGame ladderGame) {
        return new IndexInfo(participant, ladderGame.climb(index));
    }

    public Participant getParticipant() {
        return participant;
    }

    public int getIndex() {
        return index;
    }
}
