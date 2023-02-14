package domain;

import exception.EmpytInputException;
import exception.InvalidParticipantsCountException;
import java.util.List;

public class Participants {

    public Participants(String participantNames) {
        validate(participantNames);
    }

    private void validate(String participantNames) {
        if (!isExist(participantNames)) {
            throw new EmpytInputException();
        }
        if (isValidCount(splitNames(participantNames))) {
            throw new InvalidParticipantsCountException();
        }
    }

    private boolean isExist(String participantNames) {
        return !(participantNames == null || participantNames.isBlank());
    }

    private boolean isValidCount(List<String> names) {
        final int maxParticipantCount = 10;
        return names.size() > maxParticipantCount;
    }

    private List<String> splitNames(String participantNames) {
        final String delimiter = ",";
        return List.of(participantNames.split(delimiter, -1));
    }
}
