package ladder.domain;

import java.util.*;

public class InputModel {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_HEIGHT = 1;
    private static final String ERROR_MESSAGE = "입력이 올바르지 않습니다.";

    public List<String> getValidNames(String names) {
        checkBlankInput(names);

        return checkValidNames(Arrays.asList(split(names)));
    }

    private void checkBlankInput(String names) {
        if (names == null || names.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private List<String> checkValidNames(List<String> names) {
        checkEmpty(names);
        checkOverlap(names);

        for (String name : names) {
            isOverNameLength(name);
        }

        return names;
    }

    private String[] split(String input) {
        return input.trim().split(",");
    }

    private void checkEmpty(List<String> validNames) {
        if (validNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkOverlap(List<String> validNames) {
        Set<String> overlapNames = new HashSet<>(validNames);
        if (overlapNames.size() != validNames.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void isOverNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValidLadderHeight(int number) {
        if (number < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return number;
    }

    public List<String> getValidReward(String rewards, int numberOfPlayers) {
        checkBlankInput(rewards);

        return checkValidReward(Arrays.asList(split(rewards)), numberOfPlayers);
    }

    private List<String> checkValidReward(List<String> rewards, int numberOfPlayers) {
        checkEmpty(rewards);

        return checkNumberOfMatch(rewards, numberOfPlayers);
    }

    private List<String> checkNumberOfMatch(List<String> rewards, int numberOfPlayers) {
        if (rewards.size() != numberOfPlayers) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return rewards;
    }

    public Map<Integer, String> getWrappedValidReward(List<String> rewards) {
        Map<Integer, String> result = new HashMap<>();

        for (int i = 0; i < rewards.size(); i++) {
            result.put(i, rewards.get(i));
        }

        return result;
    }
}