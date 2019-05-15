package ladder.view;

import ladder.model.Ladder;
import ladder.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class OutputView {
    public static void main(String[] argc) {
        List<Person> people = Arrays.asList(
                new Person("Kim"),
                new Person("Park"),
                new Person("Lee"),
                new Person("Choi"),
                new Person("G"),
                new Person("Jeong"),
                new Person("No")
        );
        List<String> rewards = Arrays.asList(
                "300",
                "60,000",
                "꽝",
                "꽝",
                "1,500",
                "꽝",
                "10"
        );
        final int wordsMaxLength = Math.max(Collections.max(people).getNameLength(), Collections.max(rewards).length());
        Ladder ladder = new Ladder(people.size(), 11);
        List<Person> result = 
        printPeople(people, wordsMaxLength);
        printLadder(ladder, wordsMaxLength);
        ladder.apply(people);
        printWords(rewards, wordsMaxLength);
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i) + " : " + rewards.get(i));
        }
    }

    public static void printWords(List<String> words, int maxLength) {
        StringBuilder namesWithPadding = new StringBuilder();
        words.forEach(word -> {
            String padding = " ".repeat((maxLength - word.length()) / 2);
            namesWithPadding.append(" " + padding + word + padding + " ");
        });
        System.out.println(namesWithPadding.toString());
    }

    public static void printPeople(List<Person> people, int maxLength) {
        printWords(people.stream().map(x -> x.toString()).collect(Collectors.toList()), maxLength);
    }

    public static void printLadder(Ladder ladder, int length) {
        ladder.getLevels().forEach(level -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                result.append("|" + drawHorizontalLine(level.getLines().contains(i), length));
            }
            result.append("|");
            System.out.println(result);
        });
    }

    private static String drawHorizontalLine(boolean exists, int width) {
        if (exists) {
            return "-".repeat(width);
        }
        return " ".repeat(width);
    }
}