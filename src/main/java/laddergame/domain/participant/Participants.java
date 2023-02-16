package laddergame.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.domain.message.ErrorMessage.INVALID_DUPLICATE_NAME;
import static laddergame.domain.message.ErrorMessage.INVALID_PARTICIPANT_COUNT;

public class Participants {

    private static final String DELIMITER = ",";
    private static final int MIN_COUNT = 1;
    private final List<Participant> participants;

    private Participants(final String names) {
        List<String> participantNames = splitNames(names);
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

    private void validateParticipantCount(List<String> participantNames) {
        if (participantNames.size() == MIN_COUNT) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_COUNT.getMessage());
        }
    }

    private void validateDuplicateName(List<String> participantNames) {
        int uniqueCount = (int) participantNames.stream().distinct().count();
        if (uniqueCount != participantNames.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NAME.getMessage());
        }
    }

    private List<Participant> makeParticipants(final List<String> participantNames) {
        return participantNames.stream()
                .map(Participant::create)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
