package laddergame.view;

import java.util.List;
import laddergame.model.Ladder;
import laddergame.model.Persons;

public class OutputView {
    private final static String VERTICAL_LINE = "|";
    private static final String PRINT_RESULT_MSG = "실행 결과";

    public void printResult(Ladder ladder, Persons persons) {
        System.out.println(System.lineSeparator()+PRINT_RESULT_MSG+System.lineSeparator());
        printPersons(persons);
        printLadder(ladder);
    }

    private void printPersons(Persons persons) {
        for (int i = 0; i < persons.getSize(); i++) {
            System.out.printf("%6s", persons.getPerson(i).getName());
        }
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
