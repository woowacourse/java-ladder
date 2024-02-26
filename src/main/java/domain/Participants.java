package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Participants {

    private final List<Participant> participants = new ArrayList<>();

    public Participants(List<String> names) {
        validateDuplicatedNames(names);
        prepareParticipants(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("참가자의 이름은 중복될 수 없습니다.");
        }
    }

    private void prepareParticipants(List<String> names) {
        for (String name : names) {
            participants.add(new Participant(name));
        }
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
