package ladder.view;

import java.util.List;

public class InputViewValidator {

    private static final int MAX_NAMES_COUNT = 10000;
    private static final int MIN_NAMES_COUNT = 2;
    private static final String NAMES_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참여자의 수는 2명 이상 10000명 이하여야합니다.";
    private static final String NAME_CAN_NOT_BE_ALL_EXCEPTION_MESSAGE = "[ERROR] 참여자의 이름은 all일 수 없습니다.";
    private static final String NAME_CAN_NOT_DUPLICATED_EXCEPTION_MESSAGE = "[ERROR] 참여자의 이름은 중복될 수 없습니다.";
    private static final String NONE_NUMERIC_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력해야합니다.";

    public static void validateNamesCount(final int count) {
        if (count > MAX_NAMES_COUNT || count < MIN_NAMES_COUNT) {
            throw new IllegalArgumentException(NAMES_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public static void validateNameIsAll(final String playerName) {
        if ("all".equals(playerName)) {
            throw new IllegalArgumentException(NAME_CAN_NOT_BE_ALL_EXCEPTION_MESSAGE);
        }
    }

    public static void validateDuplicatedNames(final List<String> playerNames) {
        int distinctPlayerCount = (int) playerNames.stream()
                .distinct()
                .count();

        if (distinctPlayerCount != playerNames.size()) {
            throw new IllegalArgumentException(NAME_CAN_NOT_DUPLICATED_EXCEPTION_MESSAGE);
        }
    }

    public static void validateNumeric(final String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NONE_NUMERIC_EXCEPTION_MESSAGE);
        }
    }
}
