package ladder.Model;

import java.util.*;

public class InputModel {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_HEIGHT = 1;
    private static String ERROR_MESSAGE = "입력이 올바르지 않습니다.";

    List<String> getValidNames(String names) throws Exception{
        checkBlank(names);

        List<String> validNames = Arrays.asList(names.trim().split(","));
        checkEmpty(validNames);

        checkOverlap(validNames);

        for (String name : validNames) {
            isInValidNameLength(name);
        }

        return validNames;
    }

    private void checkBlank(String names) {
        if (names == null || names.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
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


    private void isInValidNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValidLadderHeight(int number) throws Exception {
        if (number < MIN_HEIGHT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return number;
    }

}