package domain;

public class InputValidator {
    public void validatePlayers(String input) {
        validateBlank(input);
        validateDoubleDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    private void validateEndWord(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStartWord(String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDoubleDelimiter(String input) {
        if (input.contains(",".repeat(2))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
