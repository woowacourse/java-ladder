package domain;

import java.util.List;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(final Participants participants, final Ladder ladder, final Prizes prizes) {
        validatePrizesSize(participants.count(), prizes);
        this.participants = participants;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    private void validatePrizesSize(int participantsCount, Prizes prizes) {
        if (prizes.doNotHaveSizeOf(participantsCount)) {
            throw new IllegalArgumentException("참가자 수와 상품 수는 같아야 합니다");
        }
    }

    public String findPrizeFor(String participantName) {
        Position start = participants.findPositionOf(participantName);
        Position destination = ladder.findDestinationFrom(start);
        return prizes.getPrizeAt(destination);
    }

    public List<String> getParticipantNames() {
        return participants.getNames();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPrizes() {
        return prizes.getPrizes();
    }
}
