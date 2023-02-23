package laddergame.domain.participant;

import laddergame.domain.exception.DuplicateException;
import laddergame.domain.exception.participant.ParticipantCountLowerException;
import laddergame.domain.exception.participant.ParticipantNamesEmptyException;
import laddergame.domain.exception.participant.ParticipantsNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_COUNT = 1;
    private static final String DELIMITER = ",";
    private static final String ALL_PARTICIPANTS = "all";

    private final List<Participant> participants;

    private Participants(final String names) {
        List<String> participantNames = splitNames(names);
        participantNames = trimNames(participantNames);
        validateBlankNames(participantNames);
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

    public List<Participant> getResultParticipants(final String participantName) {
        String trimName = participantName.trim();
        if (trimName.equalsIgnoreCase(ALL_PARTICIPANTS)) {
            return List.copyOf(participants);
        }
        Participant targetParticipant = getTargetParticipant(trimName);
        return List.of(targetParticipant);
    }

    private List<String> splitNames(final String names) {
        return Arrays.asList(names.split(DELIMITER));
    }

    private List<String> trimNames(final List<String> participantNames) {
        return participantNames.stream()
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateBlankNames(final List<String> participantNames) {
        if (participantNames.isEmpty()) {
            throw new ParticipantNamesEmptyException();
        }
    }

    private void validateParticipantCount(final List<String> participantNames) {
        if (participantNames.size() == MIN_COUNT) {
            throw new ParticipantCountLowerException(MIN_COUNT);
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

    private Participant getTargetParticipant(final String trimName) {
        List<String> participantNames = getParticipantNames();
        return participants.stream()
                .filter(participant -> participant.isSameName(trimName))
                .findFirst()
                .orElseThrow(() -> new ParticipantsNotFoundException(String.join(",", participantNames)));
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
