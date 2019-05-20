package ladder.domain;

import java.util.*;

public class InputModel {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_HEIGHT = 1;
    private static final String ERROR_MESSAGE = "입력이 올바르지 않습니다.";

    public static List<String> getValidNames(String names) {
        checkBlankInput(names);

        return checkValidNames(Arrays.asList(split(names)));
    }

    private static void checkBlankInput(String names) {
        if (names == null || names.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static List<String> checkValidNames(List<String> names) {
        checkEmpty(names);
        checkOverlap(names);

        for (String name : names) {
            isOverNameLength(name);
        }

        return names;
    }

    private static String[] split(String input) {
        return input.trim().split(",");
    }

    private static void checkEmpty(List<String> validNames) {
        if (validNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void checkOverlap(List<String> validNames) {
        Set<String> overlapNames = new HashSet<>(validNames);
        if (overlapNames.size() != validNames.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isOverNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static int getValidLadderHeight(int number) {
        if (number < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return number;
    }

    public static List<String> getValidReward(String gameRewards, int numberOfPlayers) {
        checkBlankInput(gameRewards);

        return checkValidReward(Arrays.asList(split(gameRewards)), numberOfPlayers);
    }

    private static List<String> checkValidReward(List<String> gameRewards, int numberOfPlayers) {
        checkEmpty(gameRewards);

        return checkNumberOfMatch(gameRewards, numberOfPlayers);
    }

    private static List<String> checkNumberOfMatch(List<String> gameRewards, int numberOfPlayers) {
        if (gameRewards.size() != numberOfPlayers) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return gameRewards;
    }

    public static Map<String, String> getWrappedValidReward(List<String> gameRewards) {
        Map<String, String> result = new HashMap<>();

        for (int i = 0; i < gameRewards.size(); i++) {
            result.put(String.valueOf(i), gameRewards.get(i));
        }

        return result;
    }
}