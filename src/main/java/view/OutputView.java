package view;

import java.util.List;
import model.dto.ParticipantName;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printParticipantsName(List<ParticipantName> participantsNames) {
        List<String> formattedParticipantsName = participantsNames.stream()
                .map(m -> String.format("%5s", m.name()))
                .toList();
        System.out.println(String.join(" ", formattedParticipantsName));
    }
}
