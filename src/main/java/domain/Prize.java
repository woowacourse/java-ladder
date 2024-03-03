package domain;

import java.util.Objects;

public class Prize {

    private static final int MAXIMUM_LENGTH = 5;

    private final String prize;

    Prize(String prize) {
        validate(prize);
        this.prize = prize;
    }

    private void validate(String inputPrize) {
        if (inputPrize == null || inputPrize.isEmpty() || MAXIMUM_LENGTH < inputPrize.length()) {
            throw new IllegalArgumentException(
                    String.format("결과의 길이는 최대 %d자만 입력 가능합니다. 입력값: %s", MAXIMUM_LENGTH, inputPrize));
        }

        if (isInvalidCharacter(inputPrize)) {
            throw new IllegalArgumentException(String.format("결과는 영어, 한글, 숫자만 가능합니다. 입력값: %s", inputPrize));
        }
    }

    private boolean isInvalidCharacter(String inputPrize) {
        return inputPrize.chars()
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

    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prize prize1)) {
            return false;
        }
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
