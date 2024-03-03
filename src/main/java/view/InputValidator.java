package view;

public class InputValidator {
    private static final String NAME_DELIMITER = InputView.DELIMITER;

    public void validatePlayers(final String input) {
        validateBlank(input);
        validateDoubleDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    public void validatePrizes(final String input, final int playerCount) {
        validateBlank(input);
        validateDoubleDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
        validateCount(input, playerCount);
    }

    public void validateHeight(final String input) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input);
    }

    public void validateSearchingPlayer(final String input) {
        validateBlank(input);
    }

    private void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private void validateDoubleDelimiter(final String input) {
        if (input.contains(NAME_DELIMITER.repeat(2))) {
            throw new IllegalArgumentException("올바른 형태로 구분자로 나뉘어 입력해주세요.");
        }
    }

    private void validateStartWord(final String input) {
        if (input.startsWith(NAME_DELIMITER)) {
            throw new IllegalArgumentException("입력은 구분자로 시작할 수 없습니다.");
        }
    }

    private void validateEndWord(final String input) {
        if (input.endsWith(NAME_DELIMITER)) {
            throw new IllegalArgumentException("입력은 구분자로 끝날 수 없습니다.");
        }
    }

    private void validateCount(final String input, final int playerCount) {
        if (input.split(NAME_DELIMITER).length != playerCount) {
            throw new IllegalArgumentException("실행 결과는 참여자 수와 일치해야합니다.");
        }

    }

    private void validateNumeric(final String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("수로 입력해주세요.");
        }
    }

    private void validateRange(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 범위의 수를 입력해주세요.");
        }
    }
}
