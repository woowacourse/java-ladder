package ladder.domain.participant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParticipantGroup {
    private static final int MIN_PARTICIPANTS_NUMBER = 2;

    private final List<Participant> participants = new ArrayList<>();

    public ParticipantGroup(final List<String> names) {
        validateMinParticipants(names);
        validateDuplicatedParticipants(names);
        names.forEach(x -> this.participants.add(new Participant(x)));
    }

    private void validateMinParticipants(final List<String> participants) {
        if (participants.size() < MIN_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatedParticipants(final List<String> participants) {
        if (participants.size() != new HashSet<>(participants).size()) {
            throw new IllegalArgumentException("참가자 명은 중복될 수 없습니다.");
        }
    }

    public int getSize() {
        return participants.size();
    }

    public List<Participant> getParticipantList() {
        return participants;
    }

    public Participant getNthParticipant(final int index) {
        return participants.get(index);
    }
}
