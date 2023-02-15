package laddergame.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_COUNT = 1;

    private final List<Participant> participants;

    public Participants(String names) {
        String[] participantNames = splitNames(names);
        validateParticipantCount(participantNames);
        validateDuplicateName(participantNames);
        participants = Arrays.stream(participantNames)
                .map(name -> new Participant(name))
                .collect(Collectors.toUnmodifiableList());
    }

    public int size() {
        return participants.size();
    }

    private String[] splitNames(final String names) {
        return names.split(",");
    }

    private void validateParticipantCount(String[] participantNames) {
        if (participantNames.length == MIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 참여자는 최소 한 명 이상 입력해야 합니다.");
        }
    }

    private void validateDuplicateName(String[] participantNames) {
        int uniqueCount = (int) Arrays.stream(participantNames).distinct().count();
        if (uniqueCount != participantNames.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력할 수 없습니다.");
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
