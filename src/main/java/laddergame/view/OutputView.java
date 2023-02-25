package laddergame.view;

import java.util.List;
import laddergame.model.Ladder;
import laddergame.model.People;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String LADDER_RESULT_MSG = "사다리 결과";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public void printLadderResult(Ladder ladder, People people) {
        System.out.println(System.lineSeparator() + LADDER_RESULT_MSG + System.lineSeparator());
        printPeople(people);
        printLadder(ladder);
    }

    private void printPeople(People people) {
        people.getPeople().forEach(person -> System.out.printf("%6s", person.getName()));
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getSize(); i++) {
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
