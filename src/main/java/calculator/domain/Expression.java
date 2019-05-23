package calculator.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {
	private static final String BLANK_EXPRESSION = "0";
	private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");
	private static final String COMMA_OR_COLON = ",|:";

	private final String expression;

	public Expression(String expression) {
		if (StringUtils.isBlank(expression)) {
			expression = BLANK_EXPRESSION;
		}
		this.expression = expression;
	}

	List<Number> getNumbers() {
		return splitExpression().stream()
				.map(Number::new)
				.collect(Collectors.toList());
	}

	List<String> splitExpression() {
		Matcher matcher = CUSTOM_PATTERN.matcher(this.expression);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return Arrays.asList(matcher.group(2).split(customDelimiter));
		}
		return Arrays.asList(expression.split(COMMA_OR_COLON));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Expression)) return false;
		Expression that = (Expression) o;
		return Objects.equals(expression, that.expression);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expression);
	}
}
