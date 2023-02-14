package laddergame.domain.participants;

import laddergame.domain.participant.Participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(String names) {
        String[] participantNames = splitNames(names);
        validateDuplicateName(participantNames);
        participants = Arrays.stream(participantNames)
                .map(name -> new Participant(name))
                .collect(Collectors.toUnmodifiableList());
    }

    private String[] splitNames(final String names) {
        return names.split(",");
    }

    private void validateDuplicateName(String[] participantNames) {
        int uniqueCount = (int) Arrays.stream(participantNames).distinct().count();
        if (uniqueCount != participantNames.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력할 수 없습니다.");
        }
    }
}
