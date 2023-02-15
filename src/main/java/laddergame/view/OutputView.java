package laddergame.view;

import java.util.List;
import laddergame.model.Ladder;
import laddergame.model.Persons;

public class OutputView {
    public void printResult(Ladder ladder, Persons persons) {
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
            System.out.print("     |");
            for (boolean bool : lines) {
                if (bool) {
                    System.out.print("-----");
                }
                if (!bool) {
                    System.out.print("     ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
