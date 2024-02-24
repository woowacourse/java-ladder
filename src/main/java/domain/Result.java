package domain;

public class Result {

    private static final int MAXIMUM_LENGTH = 5;

    private final String result;

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    private void validate(String inputResult) {
        if (inputResult == null || inputResult.isEmpty() || MAXIMUM_LENGTH < inputResult.length()) {
            throw new IllegalArgumentException(
                    String.format("결과의 길이는 최대 %d자만 입력 가능합니다. 입력값: %s", MAXIMUM_LENGTH, inputResult));
        }

        if (isInvalidCharacter(inputResult)) {
            throw new IllegalArgumentException(String.format("결과는 영어, 한글, 숫자만 가능합니다. 입력값: %s", inputResult));
        }
    }

    private boolean isInvalidCharacter(String inputResult) {
        return inputResult.chars()
                .anyMatch(character -> !(isAlphabet(character) || isKorean(character) || isNumber(character)));
    }

    private boolean isAlphabet(int character) {
        return isLowerCase(character) || isUpperCase(character);
    }

    private boolean isLowerCase(int character) {
        return 'a' <= character && character <= 'z';
    }

    private boolean isUpperCase(int character) {
        return 'A' <= character && character <= 'Z';
    }

    private boolean isKorean(int character) {
        return '가' <= character && character <= '힣';
    }

    private boolean isNumber(int character) {
        return '0' <= character && character <= '9';
    }

    public String getResult() {
        return result;
    }
}
