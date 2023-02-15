package ui.output;

import domain.Lines;
import domain.People;
import domain.Peoples;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class OutputView {

    public static void printResult(Peoples peoples, Lines lines) {
        System.out.println("\n실행결과\n");
        printNames(peoples);
        printLadder(lines);
    }

    private static void printNames(Peoples peoples) {
        for (People people : peoples.getPeoples()) {
            if (people.getName().length() < 5) {
                System.out.printf("%4s  ", people.getName());
            }
            if (people.getName().length() == 5) {
                System.out.printf("%4s ", people.getName());
            }
        }
        System.out.println();
    }

    private static void printLadder(Lines lines) {
        lines.getLines()
                .forEach(line -> {
                    StringBuilder lineForm = LadderShape.getLineForm(line.getPoints());
                    System.out.println(lineForm);
                });
    }
}
