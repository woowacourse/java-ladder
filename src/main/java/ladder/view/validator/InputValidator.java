package ladder.view.validator;

import ladder.utils.Command;
import ladder.utils.Converter;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern ONLY_DIGIT_PATTERN = Pattern.compile("-?[0-9]+");

    public void validatePlayerNames(final String input) {
        validateInputBlank(input);

        if (hasInvalidName(input)) {
            throw new IllegalArgumentException(
                    String.format("참여할 사람의 이름이 '%s' 일 수 없습니다.", Command.EXPRESSION_OF_ALL_PLAYER.getExpression()));
        }
    }

    private boolean hasInvalidName(final String input) {
        final List<String> names = Converter.stringToList(input);

        return names.stream()
                .anyMatch(Command.EXPRESSION_OF_ALL_PLAYER::isMatch);
    }

    public void validatePrizes(final String input) {
        validateInputBlank(input);
    }

    public void validateLadderHeight(final String input) {
        validateInputBlank(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException("사다리 높이에 대한 입력은 숫자어야 합니다.");
        }
    }

    private boolean isNotDigit(final String input) {
        return !ONLY_DIGIT_PATTERN.matcher(input)
                .matches();
    }

    public void validateNameToSeeResult(final String input) {
        validateInputBlank(input);
    }

    private void validateInputBlank(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력은 비어있을 수 없습니다.");
        }
    }
}
