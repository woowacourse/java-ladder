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

    private static final int NON_ENGLISH_CHAR_SIZE = 2;
    private static final int ENGLISH_AND_NUMBER_CHAR_SIZE = 1;

    public static void printLadderResult(People people, Lines lines, Rewards rewards) {
        System.out.println("\n" + LADDER_RESULT + "\n");
        int printStandardLength = Math.max(people.calculateMaxNameLength(), rewards.calculateMaxNameLength());
        printNames(people, printStandardLength);
        printLadder(lines, printStandardLength);
        printRewards(rewards, printStandardLength);
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
        for (; adjustLength < length; adjustLength++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    private static int correctionLength(char character) {
        if (('a' <= character && character <= 'z') || ('0' <= character && character <= '9')) {
            return ENGLISH_AND_NUMBER_CHAR_SIZE;
        }
        return NON_ENGLISH_CHAR_SIZE;
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

    public static void printRewardResult(Rewards rewards, Person targetPerson) {
        System.out.println("\n" + EXECUTE_RESULT);
        printResultTarget(rewards, targetPerson);
    }

    public static void printRewardResultAll(Rewards rewards, People people) {
        System.out.println("\n" + EXECUTE_RESULT);
        printResultAll(rewards, people);
    }

    private static void printResultAll(Rewards rewards, People people) {
        for (int i = 0; i < people.getPeople().size(); i++) {
            Person person = people.getPeople().get(i);
            printResultTarget(rewards, person);
        }
    }

    private static void printResultTarget(Rewards rewards, Person person) {
        int position = person.getPosition();
        System.out.println(person.getName().getPersonName() + " : " + rewards.getRewards().get(position).getName()
                .getRewardName());
    }
}
