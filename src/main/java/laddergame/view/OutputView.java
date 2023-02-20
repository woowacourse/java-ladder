package laddergame.view;

import java.util.List;

import laddergame.model.Ladder.Ladder;
import laddergame.model.Participants;

public class OutputView {
    private static final String RESULT_MSG = "실행결과";
    private static final String VERTICAL_LINE = "|";

    public void printResult(Ladder ladder, Participants participants) {
        System.out.println(RESULT_MSG);
        printPersons(participants);
        printLadder(ladder);
    }

    private void printPersons(Participants participants) {
        participants.getParticipants()
            .forEach(participant -> System.out.printf("%6s", participant.getName()));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            List<Boolean> lines = ladder.get(i).getLine();
            System.out.printf("%6s", VERTICAL_LINE);
            printSymbol(lines);
            System.out.println();
        }
    }

    private void printSymbol(List<Boolean> lines) {
        for (boolean bool : lines) {
            System.out.print(LineSymbol.findByBool(bool).getSymbol());
            System.out.print(VERTICAL_LINE);
        }
    }
}
