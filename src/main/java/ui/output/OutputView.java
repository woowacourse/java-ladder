package ui.output;

import domain.Lines;
import domain.People;
import domain.Person;
import domain.Reward;
import domain.Rewards;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class OutputView {

    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTE_RESULT = "실행 결과";

    public static void printLadderResult(People people, Lines lines, Rewards rewards) {
        System.out.println("\n" + LADDER_RESULT + "\n");
        printNames(people, people.calculateMaxNameLength());
        printLadder(lines, people.calculateMaxNameLength());
        printRewards(rewards, people.calculateMaxNameLength());
    }

    private static void printRewards(Rewards rewards, int maxNameLength) {
        for (Reward reward : rewards.getRewards()) {
            System.out.print(rewardNameResize(reward.getName().getRewardName(), maxNameLength));
        }
    }

    private static String rewardNameResize(String name, int length) {
        StringBuilder stringBuilder = new StringBuilder(name);
        int adjustLength = 0;
        for (char ch : name.toCharArray()) {
            adjustLength += correctionLength(ch);
        }
        for (; adjustLength<length; adjustLength++){
            stringBuilder.append(" ");
        }
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    private static int correctionLength(char character) {
        if (('a' <= character && character <= 'z') || ('0' <= character && character <= '9')) {
            return 1;
        }
        return 2;
    }

    private static void printNames(People people, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Person person : people.getPeople()) {
            stringBuilder.append(align(person.getName().getPersonName(), maxLength));
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder align(String name, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder(name);
        while (stringBuilder.length() < maxLength - 1) {
            stringBuilder = new StringBuilder(" " + stringBuilder);
        }
        while (stringBuilder.length() < maxLength) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(" ");
        return stringBuilder;
    }

    private static void printLadder(Lines lines, int maxLine) {
        lines.getLines()
                .forEach(line -> {
                    System.out.println(LadderShape.getLineForm(line.getPoints(), maxLine));
                });
    }

    public static void printRewardResult(Rewards rewards, People people, String targetName) {
        System.out.println("\n" + EXECUTE_RESULT);
        if (targetName.equals("all")) {
            printResultAll(rewards, people);
            return;
        }
        Person targetPerson = people.findPerson(targetName);
        printResultTarget(rewards, targetPerson);
    }

    private static void printResultAll(Rewards rewards, People people) {
        for (int i = 0; i < people.getPeople().size(); i++) {
            Person person = people.getPeople().get(i);
            printResultTarget(rewards, person);
        }
    }

    private static void printResultTarget(Rewards rewards, Person person) {
        int position = person.getPosition();
        System.out.println(person.getName().getPersonName() + " : " + rewards.getRewards().get(position).getName().getRewardName());
    }
}
