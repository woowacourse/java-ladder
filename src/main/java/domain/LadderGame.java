package domain;

import static java.util.List.copyOf;

import java.util.List;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final List<String> prizes;

    public LadderGame(final Participants participants, final Ladder ladder, List<String> prizes) {
        validatePrizesSize(participants.count(), prizes);
        this.participants = participants;
        this.ladder = ladder;
        this.prizes = copyOf(prizes);
    }

    private void validatePrizesSize(int participantsCount, List<String> prizes) {
        if (prizes.size() != participantsCount) {
            throw new IllegalArgumentException("참가자 수와 상품 수는 같아야 합니다");
        }
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
