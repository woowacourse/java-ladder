package ladder.output;

import ladder.Ladder;
import ladder.Participant;
import ladder.ParticipantGroup;

import java.util.List;

public class OutputView {
    public static void outputParticipants(ParticipantGroup participantGroup) {
        for (Participant participant : participantGroup.getParticipants()) {
            System.out.print(participant);
        }
        System.out.println();
    }

    public static void outputLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
