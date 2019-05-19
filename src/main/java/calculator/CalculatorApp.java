package calculator;

import calculator.domain.Calculator;
import calculator.util.StringSeparator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApp {
	public static void main(String[] args) {
		OutputView.printCalculateResult(Calculator.sumValues(getValues()));
	}

	private static String[] getValues() {
		String[] values = StringSeparator.splitString(InputView.inputValues());
		try {
			Calculator.checkCorrectValue(values);
		} catch (RuntimeException e) {
			System.out.println("잘못된 문자열입니다. 다시 입력해주세요.");
			values = getValues();
		}
		return values;
	}
}
