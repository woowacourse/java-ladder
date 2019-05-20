package stringcalculator;

import java.util.List;

public class StringCalculator {
    private List<Integer> numbers;

    public StringCalculator(String formula) {
        List<Integer> numbers = Splitter.split(DelimiterType.findDelimiterType(formula), formula);
        checkNegativeNumber(numbers);
        this.numbers = numbers;
    }

    public int addAll() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    private void checkNegativeNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isNegativeNumber)) {
            throw new IllegalArgumentException("음수는 입력받을 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }
}