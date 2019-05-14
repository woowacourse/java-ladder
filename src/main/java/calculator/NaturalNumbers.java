package calculator;

import java.util.List;

public class NaturalNumbers {
    private List<Integer> numbers;

    public NaturalNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
