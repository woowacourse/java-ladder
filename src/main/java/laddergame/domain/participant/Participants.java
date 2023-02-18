package laddergame.domain.participant;

import laddergame.domain.exception.DuplicateException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_COUNT = 1;
    private static final String DELIMITER = ",";
    public static final String INVALID_PARTICIPANT_COUNT = "[ERROR] 참여자는 최소 한 명 이상 입력해야 합니다.";

    private final List<Participant> participants;

    private Participants(final String names) {
        List<String> participantNames = splitNames(names);
        participantNames = trimNames(participantNames);
        validateParticipantCount(participantNames);
        validateDuplicateName(participantNames);
        participants = makeParticipants(participantNames);
    }

    public static Participants create(final String names) {
        return new Participants(names);
    }

    public int size() {
        return participants.size();
    }

    private List<String> splitNames(final String names) {
        return Arrays.asList(names.split(DELIMITER));
    }

    private List<String> trimNames(final List<String> participantNames) {
        return participantNames.stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateParticipantCount(final List<String> participantNames) {
        if (participantNames.size() == MIN_COUNT) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_COUNT);
        }
    }

    private void validateDuplicateName(final List<String> participantNames) {
        int uniqueCount = (int) participantNames.stream().distinct().count();
        if (uniqueCount != participantNames.size()) {
            throw new DuplicateException();
        }
    }

    private List<Participant> makeParticipants(final List<String> participantNames) {
        return participantNames.stream()
                .map(Participant::create)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }
}
