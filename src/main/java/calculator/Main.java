package calculator;

import calculator.domain.Calculator;
import calculator.domain.Splitter;
import calculator.view.InputView;
import calculator.view.OutputView;


public class Main {
    public static void main(String[] args) {
        String input = (new InputView()).startMessage();
        Splitter splitter = new Splitter(input);
        Calculator calculator = new Calculator(splitter.getExpression());
        OutputView.printResult(calculator.sum());
    }
}
