package domain;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants {

    private static final int MIN_PARTICIPANTS = 2;
    private static final String SIZE_EXCEPTION_MESSAGE = String.format("참가자는 %d명 이상이어야 합니다", MIN_PARTICIPANTS);

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = copyOf(participants);
        validateSizeOf(participants);
        validateDistinct(participants);
    }

    private void validateSizeOf(final List<Participant> participants) {
        if (participants.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateDistinct(Collection<?> collection) {
        if (hasDuplicateIn(collection)) {
            throw new IllegalArgumentException("참가자는 중복될 수 없습니다.");
        }
    }

    public Position findPositionOf(String name) {
        Participant participant = findBy(name);
        int position = participants.indexOf(participant);
        return new Position(position);
    }

    private Participant findBy(String name) {
        return participants.stream()
                .filter(participant -> participant.hasName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("그런 참가자가 없습니다"));
    }

    private boolean hasDuplicateIn(final Collection<?> target) {
        Set<?> distinct = new HashSet<>(target);
        return target.size() != distinct.size();
    }

    public List<String> getNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(toUnmodifiableList());
    }

    public int count() {
        return participants.size();
    }
}
