package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractNamesFactory implements NamesFactory {

	protected void validate(String names) {
		checkBlank(names);
		checkLastIndexOfInput(names);
	}

	private void checkLastIndexOfInput(final String input) throws IllegalArgumentException {
		if (input.lastIndexOf(this.DELIMITER) == (input.length() - 1)) {
			throw new IllegalArgumentException("콤마로 끝나면 안됩니다");
		}
	}

	private void checkBlank(final String input) throws IllegalArgumentException {
		if (StringUtils.isBlank(input)) {
			throw new IllegalArgumentException("공백 문자를 입력하지마세요");
		}
	}
}
