package ladder.controller;

import ladder.*;
import ladder.input.InputView;
import ladder.output.OutputView;

public class Main {
    public static void main(String[] args) {
        ParticipantGroup participantGroup = createParticipantGroup();
        ResultGroup resultGroup = createResultGroup(participantGroup);
        Ladder ladder = createLadder(participantGroup);

        OutputView.outputParticipants(participantGroup);
        OutputView.outputLadder(ladder);
        OutputView.outputResults(resultGroup);
        LadderGame ladderGame = createLadderGame(participantGroup, ladder, resultGroup);
        ladderGame.play();

        outputResult(ladderGame);
    }

    private static void outputResult(LadderGame ladderGame) {
        String name;
        do {
            name = InputView.inputParticipant();
            OutputView.outputResult(name, ladderGame.result());
        } while (!name.equals("all"));
    }

    private static ParticipantGroup createParticipantGroup() {
        try {
            return new ParticipantGroup(InputView.inputParticipants());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createParticipantGroup();
        }
    }

    private static ResultGroup createResultGroup(ParticipantGroup participantGroup) {
        try {
            return new ResultGroup(participantGroup, ResultGenerator.generate(InputView.inputResult()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createResultGroup(participantGroup);
        }
    }

    private static Ladder createLadder(ParticipantGroup participantGroup) {
        try {
            return LadderGenerator.generate(participantGroup, InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLadder(participantGroup);
        }
    }

    private static LadderGame createLadderGame(ParticipantGroup participantGroup, Ladder ladder, ResultGroup resultGroup) {
        return new LadderGame(participantGroup, ladder, resultGroup);
    }
}
