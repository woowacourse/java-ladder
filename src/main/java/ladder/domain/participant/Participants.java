package ladder.domain.participant;

import ladder.domain.ladder.Ladder;

import java.util.*;

public class Participants {
    private static final int MIN_PARTICIPANTS_COUNT = 2;

    private final Map<Participant, Integer> participantsWithPosition;

    public Participants(final List<String> names) {
        validateParticipantsCount(names);
        validateDuplicatedNames(names);
        this.participantsWithPosition = createParticipantsWitPosition(names);
    }

    private void validateParticipantsCount(final List<String> names) {
        if (names.size() < MIN_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException("참가자 수는 2명 이상입니다.");
        }
    }

    private void validateDuplicatedNames(final List<String> names) {
        final Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() < names.size()) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다.");
        }
    }

    private Map<Participant, Integer> createParticipantsWitPosition(final List<String> names) {
        Map<Participant, Integer> createdParticipantsWithPosition = new LinkedHashMap<>();
        for (int order = 0; order < names.size(); order++) {
            createdParticipantsWithPosition.put(new Participant(names.get(order)), order);
        }
        return createdParticipantsWithPosition;
    }

    public int getNecessaryLadderWidth() {
        return participantsWithPosition.size() - 1;
    }

    public void playAll(final Ladder ladder) {
        for (final Map.Entry<Participant, Integer> entry: participantsWithPosition.entrySet()) {
            final Participant participant = entry.getKey();
            final int finalPosition = ladder.playFrom(entry.getValue());
            participantsWithPosition.put(participant, finalPosition);
        }
    }

    public List<String> getParticipantsName() {
        return participantsWithPosition.keySet()
                .stream()
                .map(Participant::getName)
                .toList();
    }

    public Map<Participant, Integer> getParticipantsWithPosition() {
        return participantsWithPosition;
    }
}
