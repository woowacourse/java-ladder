package ladder.output;

import ladder.*;

public class OutputView {
    private static final String BLANK = "     ";

    public static void outputParticipants(ParticipantGroup participantGroup) {
        for (Participant participant : participantGroup.getParticipants()) {
            System.out.print(participant + BLANK);
        }
        System.out.println();
    }

    public static void outputLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(line);
        }
    }

    public static void outputResults(ResultGroup resultGroup) {
        for (Result result : resultGroup.getResults()) {
            System.out.print(result + BLANK);
        }
        System.out.println();
    }

    public static void outputResult() {

    }
}
