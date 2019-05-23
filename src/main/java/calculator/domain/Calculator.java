package calculator.domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
	private static final String REGEX_OF_NUMBER = "[0-9]+";
	private static final Pattern pattern = Pattern.compile(REGEX_OF_NUMBER);

	public static int sumValues(String[] values) {
		return Arrays.stream(values)
				.mapToInt(value -> Integer.parseInt(value))
				.sum()
				;
	}

	public static void checkCorrectValue(String[] values) {
		if (!Arrays.stream(values)
				.allMatch(value -> pattern.matcher(value).matches())) {
			throw new RuntimeException();
		}
	}
}
