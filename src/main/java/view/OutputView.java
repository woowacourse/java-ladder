package view;

import java.util.List;
import model.dto.ParticipantsName;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printParticipantsName(ParticipantsName participantsName) {
        List<String> formattedParticipantsName = participantsName.names().stream()
                .map(m -> String.format("%5s", m))
                .toList();
        System.out.println(String.join(" ", formattedParticipantsName));
    }
}
