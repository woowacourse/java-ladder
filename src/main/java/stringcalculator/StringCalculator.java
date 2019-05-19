package stringcalculator;

import java.util.List;

public class StringCalculator {
    private List<Integer> numbers;

    public StringCalculator(String formula) {
        numbers = DelimiterType.findDelimiterType(formula).separateString(formula);
        checkNegativeNumber(numbers);
    }

    public int addAll() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private void checkNegativeNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException("음수는 입력받을 수 없습니다.");
        }
    }
}