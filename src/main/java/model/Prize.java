package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Prize {

    private static final String DELIMITER = ",";
    private static final int MIN_RANGE_LIMIT = 1;
    private static final int MAX_RANGE_LIMIT = 5;

    private final List<String> prizes;

    public Prize(String inputText) {
        List<String> parsedInput = Arrays.stream(inputText.split(DELIMITER)).toList();
        validateBlankNames(parsedInput);
        validateNameLength(parsedInput);
        prizes = parsedInput;
    }

    private void validateBlankNames(List<String> prizeNames) {
        boolean hasBlankName = prizeNames.stream().anyMatch(String::isBlank);

        if (hasBlankName) {
            throw new IllegalArgumentException("상품의 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(List<String> prizeNames) {
        List<String> legalRangeNames = prizeNames.stream().filter(name -> isInRange(name.length())).toList();

        if (new HashSet<>(legalRangeNames).size() != prizeNames.size()) {
            String formattedMessage = "상품은 %d~%d사이의 숫자만 허용합니다.".formatted(MIN_RANGE_LIMIT, MAX_RANGE_LIMIT);
            throw new IllegalArgumentException(formattedMessage);
        }
    }

    private boolean isInRange(int textLength) {
        return textLength <= MAX_RANGE_LIMIT && textLength >= MIN_RANGE_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize = (Prize) o;
        return Objects.equals(prizes, prize.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
