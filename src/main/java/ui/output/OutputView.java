package ui.output;

import domain.Lines;
import domain.People;
import domain.Person;
import domain.Rewards;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class OutputView {

    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTE_RESULT = "실행 결과";

    public static void printResult(People people, Lines lines, int maxNameLength) {
        System.out.println("\n" + LADDER_RESULT + "\n");
        printNames(people, maxNameLength);
        printLadder(lines, maxNameLength);
    }

    private static void printNames(People people, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Person person : people.getPeople()) {
            stringBuilder.append(align(person.getName(), maxLength));
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

    private static void printLadder(Lines lines, int maxLine) {
        lines.getLines()
                .forEach(line -> {
                    StringBuilder lineForm = LadderShape.getLineForm(line.getPoints(), maxLine);
                    System.out.println(lineForm);
                });
    }

    public static void printRewardResult(Rewards rewards, People people, String targetName) {
        System.out.println("\n" + EXECUTE_RESULT);
        if(targetName.equals("all")){
            printResultAll(rewards, people);
            return;
        }
        Person targetPerson = people.findPerson(targetName);
        printResultTarget(rewards, targetPerson);
    }

    private static void printResultAll(Rewards rewards, People people){
        for (int i = 0; i < people.getPeople().size(); i++) {
            Person person = people.getPeople().get(i);
            printResultTarget(rewards, person);
        }
    }

    private static void printResultTarget(Rewards rewards, Person person) {
        int position = person.getPosition();
        System.out.println(person.getName() + " : " + rewards.getRewards().get(position).getName());
    }
}
