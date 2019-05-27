package ladder.domain.participant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParticipantGroup {
    private static final int MIN_PARTICIPANTS_NUMBER = 2;

    private final List<Participant> participants;

    public ParticipantGroup(final List<String> names) {
        validateMinParticipants(names);
        validateDuplicatedParticipants(names);
        this.participants = new ArrayList<>();
        names.stream().forEach(x -> this.participants.add(new Participant(x)));
    }

    private void validateMinParticipants(List<String> participants) {
        if (participants.size() < MIN_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatedParticipants(List<String> participants) {
        if (participants.size() != new HashSet<>(participants).size()) {
            throw new IllegalArgumentException("참가자 명은 중복될 수 없습니다.");
        }
    }

    public int getSize() {
        return participants.size();
    }

    public Participant getNthParticipant(final int index) {
        return participants.get(index);
    }

    public List<Participant> getParticipantList() {
        return participants;
    }

    public int getOrder(Participant p) {
        return participants.indexOf(p);
    }
}
