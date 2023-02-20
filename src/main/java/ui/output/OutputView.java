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
        int maxLength = person.getPerson().stream().mapToInt(p -> p.getName().length()).max().orElseThrow();
        StringBuilder stringBuilder = new StringBuilder();

        for (People people : person.getPerson()) {
            stringBuilder.append(align(people.getName(), maxLength));
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder align(String name, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder(name);
        while(stringBuilder.length() < maxLength - 1) {
            stringBuilder = new StringBuilder(" " + stringBuilder);
        }
        while(stringBuilder.length() < maxLength) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(" ");
        return stringBuilder;
    }

    private static void printLadder(Lines lines) {
        lines.getLines()
                .forEach(line -> {
                    StringBuilder lineForm = LadderShape.getLineForm(line.getPoints());
                    System.out.println(lineForm);
                });
    }
}
