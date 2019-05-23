package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringSeparator {
	private static final String REGEX_OF_DEFAULT_SEPARATOR = ",|:";
	private static final String REGEX_OF_INPUT_FORMAT = "//(.)\n(.*)";

	public static String[] splitString(String input) {
		if (StringUtils.isBlank(input)) {
			return new String[]{};
		}
		return splitStringWithSeparator(input);
	}

	private static String[] splitStringWithSeparator(String input) {
		Pattern pattern = Pattern.compile(REGEX_OF_INPUT_FORMAT);
		Matcher m = pattern.matcher(replaceNewLine(input));

		if (m.find()) {
			String customDelimiter = m.group(1);
			String newRegex = Pattern.quote(customDelimiter) + "|" + REGEX_OF_DEFAULT_SEPARATOR;
			return m.group(2).split(newRegex);
		}

		return input.split(REGEX_OF_DEFAULT_SEPARATOR);
	}

	private static String replaceNewLine(String input) {
		return input.replaceAll("\\\\n", "\n");
	}
}
