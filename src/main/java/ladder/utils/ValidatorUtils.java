package ladder.utils;

import java.util.List;

public class ValidatorUtils {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MIN_HEIGHT = 1;

    public static void checkNames(List<String> names) {
        checkBlank(names);

        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkBlank(List<String> input) {
        if (input.size() < 1) {
            System.err.println("빈칸이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void checkNameLength(String name) {
        if (name.trim().length() > MAX_NAME_LENGTH || name.trim().length() < MIN_NAME_LENGTH) {
            System.err.println("이름은 1~5자만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void checkHeight(int height) {
        if (height < MIN_HEIGHT) {
            System.err.println("높이는 자연수만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void checkItems(List<String> items, int numberOfPeople) {
        checkBlank(items);
        checkNumberOfItems(items, numberOfPeople);
        for (String item : items) {
            checkItemLength(item);
        }
    }

    private static void checkItemLength(String item) {
        if (item.trim().length() < MIN_NAME_LENGTH) {
            System.err.println("빈 아이템이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberOfItems(List<String> items, int numberOfPeople) {
        if (items.size() != numberOfPeople) {
            System.err.println("아이템의 수가 사람의 수와 같지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void checkParticipant(List<String> names, String participant) {
        if (participant.length() == 0) {
            System.err.println("입력이 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }

        if (!names.contains(participant) && !participant.equals("all")) {
            System.err.println("해당 참가자가 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
