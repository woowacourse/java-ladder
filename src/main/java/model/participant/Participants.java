package model.participant;

import dto.ParticipantName;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.Constant;

public class Participants {
    private static final int MIN_PARTICIPANT_COUNT = 2;

    private final List<Participant> participants;

    public Participants(List<String> names) {
        validateNameSize(names);
        validateDuplicateName(names);
        this.participants = names.stream()
                .map(Participant::new)
                .toList();
    }

    private void validateNameSize(List<String> names) {
        if (names.size() < MIN_PARTICIPANT_COUNT) {
            throw new IllegalArgumentException("참여할 사람은 " + MIN_PARTICIPANT_COUNT + "명 이상이어야한다.");
        }
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없다");
        }
    }

    public String findByName(String name) {
        if (name.equals(Constant.TOTAL_RESULT_KEYWORD)) {
            return Constant.TOTAL_RESULT_KEYWORD;
        }
        return participants.stream().filter(m -> m.hasEquivalentName(name))
                .findAny()
                .map(Participant::getName)
                .orElseThrow(() -> new IllegalArgumentException("참여한 사람 목록에 일치하는 이름이 있어야한다"));
    }

    public Participant findParticipantByIndex(int index) {
        return participants.get(index);
    }

    public List<ParticipantName> convertToParticipantsNames() {
        return participants.stream().map(ParticipantName::new).toList();
    }

    public int size() {
        return participants.size();
    }
}
