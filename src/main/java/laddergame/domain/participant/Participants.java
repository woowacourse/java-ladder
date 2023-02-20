package laddergame.domain.participant;

import laddergame.domain.exception.DuplicateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_COUNT = 1;
    private static final String DELIMITER = ",";
    private static final String PARTICIPANTS = "참가자는";
    private static final String ALL_PARTICIPANTS = "all";
    private static final String INVALID_PARTICIPANT_COUNT = "[ERROR] %s 최소 %d명 이상 입력해야 합니다.";
    private static final String INVALID_PARTICIPANT_NAME = "[ERROR] 참여자 리스트에 존재하지 않습니다. 현재 참여자 리스트 = %s";

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
            throw new IllegalArgumentException(String.format(INVALID_PARTICIPANT_COUNT, PARTICIPANTS, MIN_COUNT));
        }
    }

    private void validateDuplicateName(final List<String> participantNames) {
        int uniqueCount = (int) participantNames.stream().distinct().count();
        if (uniqueCount != participantNames.size()) {
            throw new DuplicateException();
        }
    }

    private List<Participant> makeParticipants(final List<String> participantNames) {
        List<Participant> participants = new ArrayList<>();
        for (int participantOrder = 0; participantOrder < participantNames.size(); participantOrder++) {
            String participantName = participantNames.get(participantOrder);
            Participant participant = Participant.create(participantName, participantOrder);
            participants.add(participant);
        }
        return List.copyOf(participants);
    }

    public List<String> getResultParticipantNames(final String participantName) {
        String trimName = participantName.trim();
        List<String> participantNames = getParticipantNames();
        if (trimName.equalsIgnoreCase(ALL_PARTICIPANTS)) {
            return participantNames;
        }
        if (!participantNames.contains(trimName)) {
            throw new IllegalArgumentException(String.format(INVALID_PARTICIPANT_NAME, String.join(",", participantNames)));
        }
        return List.of(trimName);
    }

    private List<String> getParticipantNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }
}
