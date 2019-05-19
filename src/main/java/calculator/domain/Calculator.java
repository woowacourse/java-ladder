package calculator.domain;

import java.util.Arrays;

public class Calculator {
	private static final String REGEX_OF_NUMBER = "[0-9]+";

	public static int sumValues(String[] values) {
		return Arrays.stream(values).mapToInt(value -> Integer.parseInt(value)).sum();
	}

	public static void checkCorrectValue(String[] values) {
		if (!Arrays.stream(values).allMatch(value -> value.matches(REGEX_OF_NUMBER))) {
			throw new RuntimeException();
		}
	}
}
