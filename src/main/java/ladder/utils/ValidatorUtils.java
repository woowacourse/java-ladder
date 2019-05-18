package ladder.utils;

import java.util.List;

public class ValidatorUtils {
    private static final int EMPTY = 0;
    private static final int MIN_LENGTH_OF_STRING = 1;
    private static final int MIN_LENGTH_OF_HEIGHT = 1;
    private static final int MAX_LENGTH_OF_NAME = 5;

    public static void checkNames(List<String> names) {
        if (names.size() == EMPTY) {
            throw new IllegalArgumentException("이름을 제대로 입력해 주세요.");
        }
        if (names.size() == 1) {
            throw new IllegalArgumentException("혼자서는 사다리 게임을 할 수 없습니다.");
        }
        for (String name : names) {
            checkLengthOfName(name);
        }
    }

    private static void checkLengthOfName(String name) {
        if (name.trim().length() < MIN_LENGTH_OF_STRING || name.trim().length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 1~5자만 가능합니다.");
        }
    }

    public static void checkItems(List<String> items, int numberOfPeople) {
        if (items.size() == EMPTY) {
            throw new IllegalArgumentException("실행 결과를 제대로 입력해 주세요.");
        }
        if (items.size() != numberOfPeople) {
            throw new IllegalArgumentException("사람 수와 실행 결과의 수가 다릅니다.");
        }
        for (String item : items) {
            checkLengthOfItem(item);
        }
    }

    private static void checkLengthOfItem(String item) {
        if (item.trim().length() < MIN_LENGTH_OF_STRING) {
            throw new IllegalArgumentException("실행 결과를 제대로 입력해 주세요.");
        }
    }

    public static void checkHeight(int height) {
        if (height < MIN_LENGTH_OF_HEIGHT) {
            throw new IllegalArgumentException("높이는 자연수여야 합니다.");
        }
    }

    public static void checkParticipant(String participant, List<String> names) {
        if (participant.trim().length() < MIN_LENGTH_OF_STRING) {
            throw new IllegalArgumentException("이름을 제대로 입력해 주세요.");
        }

        if (!names.contains(participant) && !participant.equals("all")) {
            throw new IllegalArgumentException("게임에 참여하지 않은 이름입니다.");
        }
    }
}
