package domain;

import exception.EmpytInputException;
import exception.InvalidParticipantsCountException;
import java.util.List;

public class Participants {

    public Participants(String participantNames) {
        final int maxParticipants = 10;

        if (participantNames == null || participantNames.isBlank()) {
            throw new EmpytInputException();
        }

        List<String> names = List.of(participantNames.split(",", -1));
        if (names.size() > maxParticipants) {
            throw new InvalidParticipantsCountException();
        }
    }


}
