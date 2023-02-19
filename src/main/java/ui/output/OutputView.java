package ui.output;

import domain.Lines;
import domain.People;
import domain.Person;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class OutputView {

    private static final String EXECUTE_RESULT = "실행결과";

    public static void printResult(Person person, Lines lines) {
        System.out.println("\n" + EXECUTE_RESULT + "\n");
        printNames(person);
        printLadder(lines);
    }

    private static void printNames(Person person) {
        for (People people : person.getPerson()) {
            calculateNameLength(people.getName());
        }
        System.out.println();
    }

    private static void calculateNameLength(String name) {
        if (name.length() < 5) {
            System.out.printf("%4s  ", name);
        }
        if (name.length() == 5) {
            System.out.printf("%4s ", name);
        }
    }

    private static void printLadder(Lines lines) {
        lines.getLines()
                .forEach(line -> {
                    StringBuilder lineForm = LadderShape.getLineForm(line.getPoints());
                    System.out.println(lineForm);
                });
    }
}
