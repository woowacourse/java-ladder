package calculator.domain;

import java.util.Objects;

public class Number {
	private static final String ZERO = "0";

	private int number;

	public Number(final String number) {
		this.number = parseNumber(number);
		if (this.number < 0) {
			throw new IllegalArgumentException("0 이상의 정수를 입력하세요");
		}
	}

	private int parseNumber(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("문자를 입력하지마세요");
		}
	}

	public static Number zeroNumber() {
		return new Number(ZERO);
	}

	public Number add(final Number operand) {
		return new Number(Integer.toString(this.number + operand.number));
	}

	public int getNumber() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Number)) return false;
		Number number1 = (Number) o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
