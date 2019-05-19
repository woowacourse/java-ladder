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

    public List<String> getValidExecuteResult(String executeResult, int countOfName) {
        checkBlankInput(executeResult);
        return checkValidExecuteResult(Arrays.asList(split(executeResult)), countOfName);
    }

    private List<String> checkValidExecuteResult(List<String> executeResult, int countOfName) {
        checkEmpty(executeResult);
        checkExecuteResultLength(executeResult, countOfName);

        return executeResult;
    }

    private String[] split(String names) {
        return names.trim().split(",");
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

    private void checkExecuteResultLength(List<String> executeResult, int countOfName) {
        if (executeResult.size() != countOfName) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValidLadderHeight(int number) {
        if (number < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return number;
    }

    public String getPlayerForResult(List<String> names, String player) {
        return checkValidPlayer(names, player);
    }

    private String checkValidPlayer(List<String> names, String player) {
        checkPlayerEmpty(player);
        if (player.equals("all")) {
            return player;
        }

        Set<String> matchNames = new HashSet<>(names);
        checkMatchedName(matchNames, player);

        return player;
    }

    private void checkPlayerEmpty(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void checkMatchedName(Set<String> matchNames, String player) {
        if (!matchNames.contains(player)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }


}