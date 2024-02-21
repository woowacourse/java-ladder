package ladder.view;

import ladder.domain.Participant;
import ladder.domain.Participants;

import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_PREFIX = "실행결과\n";
    private static final String NAME_FORMAT = "%6s";

    public void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public void printParticipants(Participants participants) {
        String participantsName = participants.getValues()
                .stream()
                .map(this::getFormattedName)
                .collect(Collectors.joining());
        System.out.println(participantsName);
    }

    private String getFormattedName(Participant participant) {
        String name = participant.getName();
        return String.format(NAME_FORMAT, name);
    }
}
