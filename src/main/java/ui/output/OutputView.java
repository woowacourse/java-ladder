package ui.output;

import domain.Lines;
import domain.People;
import domain.Peoples;

import java.util.NoSuchElementException;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class OutputView {

    private static final String EXECUTE_RESULT = "실행결과";

    public static void printResult(Peoples peoples, Lines lines) {
        System.out.println("\n" + EXECUTE_RESULT + "\n");
        printNames(peoples);
        printLadder(lines, peoples);
    }

    private static void printNames(Peoples peoples) {
        Integer maxNameLength = getMaxNameLength(peoples);
        for (People people : peoples.getPeoples()) {
            calculateNameLength(maxNameLength, people.getName());
        }
        System.out.println();
    }

    private static Integer getMaxNameLength(Peoples peoples) {
        return peoples.getPeoples().stream()
                .mapToInt(people -> people.getName().length())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private static void calculateNameLength(int maxNameLength, String name) {
        System.out.print(" ".repeat(maxNameLength - name.length()) + name + " ");
    }

    private static void printLadder(Lines lines, Peoples peoples) {
        lines.getLines()
                .forEach(line -> {
                    StringBuilder lineForm = LadderShape.getLineForm(line.getPoints(), getMaxNameLength(peoples));
                    System.out.println(lineForm);
                });
    }
}
