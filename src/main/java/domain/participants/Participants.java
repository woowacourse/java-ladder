package domain.participants;

import exception.participants.DuplicateNameException;
import exception.participants.InvalidParticipantsCountException;
import exception.view.EmptyInputException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_PARTICIPANT_COUNT = 2;
    private static final int MAX_PARTICIPANT_COUNT = 10;
    private static final String DELIMITER = ",";
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(String participantNames) {
        validate(participantNames);
        List<Participant> participants = makeAllParticipant(participantNames);
        return new Participants(participants);
    }

    private static void validate(String participantNames) {
        if (isBlank(participantNames)) {
            throw new EmptyInputException();
        }
        List<String> splitNames = splitNames(participantNames);
        if (isInvalidCount(splitNames)) {
            throw new InvalidParticipantsCountException();
        }
        if (isDuplicate(splitNames)) {
            throw new DuplicateNameException();
        }
    }

    private static List<Participant> makeAllParticipant(String participantNames) {
        return splitNames(participantNames).stream()
            .map(Participant::new)
            .collect(Collectors.toList());
    }

    private static List<String> splitNames(String participantNames) {
        return List.of(participantNames.split(DELIMITER, -1));
    }

    private static boolean isBlank(String participantNames) {
        return participantNames == null || participantNames.isBlank();
    }

    private static boolean isInvalidCount(List<String> names) {
        return names.size() < MIN_PARTICIPANT_COUNT || names.size() > MAX_PARTICIPANT_COUNT;
    }

    private static boolean isDuplicate(List<String> names) {
        return names.size() > names.stream().distinct().count();
    }

    public int getCount() {
        return participants.size();
    }

    public List<Participant> getAllParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
