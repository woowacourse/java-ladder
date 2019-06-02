package ladder.controller;

import ladder.*;
import ladder.input.InputView;
import ladder.output.OutputView;

public class Main {
    public static void main(String[] args) {
        ParticipantGroup participantGroup = createParticipant();
        Ladder ladder = createLadder(participantGroup);

        OutputView.outputParticipants(participantGroup);
        OutputView.outputLadder(ladder);
    }

    private static ParticipantGroup createParticipant() {
        try {
            return new ParticipantGroup(InputView.inputParticipants());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return createParticipant();
        }
    }

    private static Ladder createLadder(ParticipantGroup participantGroup) {
        return LadderGenerator.generate(participantGroup, InputView.inputLadderHeight());
    }
}
