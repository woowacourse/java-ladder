package domain;

import static java.util.List.copyOf;

import java.util.List;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final List<String> prizes;

    public LadderGame(final Participants participants, final Ladder ladder, List<String> prizes) {
        this.participants = participants;
        this.ladder = ladder;
        this.prizes = copyOf(prizes);
    }

    public String findPrizeFor(String participantName) {
        Position start = participants.findPositionOf(participantName);
        Position destination = ladder.findDestinationFrom(start);
        return getPrizeAt(destination);
    }

    private String getPrizeAt(Position position) {
        return prizes.get(position.getPosition());
    }

    public List<String> getParticipantNames() {
        return participants.getNames();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
