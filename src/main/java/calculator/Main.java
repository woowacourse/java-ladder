package calculator;

import calculator.domain.Calculator;
import calculator.domain.Delimiter;
import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = (new InputView()).startMessage();
        String delimiter = Delimiter.getFromString(input);
        List<Integer> numbers = Numbers.getFromString(input, delimiter);
        Calculator calculator = new Calculator(numbers);
        OutputView.printResult(calculator.sum());
    }
}
