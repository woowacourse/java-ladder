package view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String DELIMITER = ",";
	private static final String PARTICIPANTS_NAMES_REQUEST_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String RESULTS_REQUEST_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static final String LADDER_HEIGHT_REQUEST_MSG = "최대 사다리 높이는 몇 개인가요?";
	private static final String NAME_NUMBER_ERROR_MSG = "최소 두 명 이상의 참가자 이름을 입력해야합니다.";
	private static final String LAST_COMMA_ERROR_MSG = "마지막 참가자 이름이 입력되지 않았습니다.";
	private static final String HEIGHT_NATURAL_NUMBER_ERROR_MSG = "사다리 높이는 자연수여야합니다.";


	public static String[] readResults() {
		System.out.println(RESULTS_REQUEST_MSG);
		return parseListFromInput();
	}

	public static String[] readNames() {
		System.out.println(PARTICIPANTS_NAMES_REQUEST_MSG);
		return parseListFromInput();
	}

	private static String[] parseListFromInput() {
		String line = scanner.nextLine();
		System.out.println();
		validateLastComma(line);
		String[] items = line.split(DELIMITER);
		validateListLength(items);
		return items;
	}

	private static void validateLastComma(String input) {
		if (input.endsWith(DELIMITER)) {
			throw new IllegalArgumentException(LAST_COMMA_ERROR_MSG);
		}
	}

	private static void validateListLength(String[] items) {
		if (items.length <= 1) {
			throw new IllegalArgumentException(NAME_NUMBER_ERROR_MSG);
		}
	}

	public static int readHeight() {
		System.out.println(LADDER_HEIGHT_REQUEST_MSG);
		String line = scanner.nextLine();
		System.out.println();
		validateIsNatural(line);
		return Integer.parseInt(line);
	}

	private static void validateIsNatural(String line) {
		int parsedInput;
		try {
			parsedInput = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(HEIGHT_NATURAL_NUMBER_ERROR_MSG);
		}
		isNumberPositive(parsedInput);
	}

	private static void isNumberPositive(int parsedInput) {
		if (parsedInput <= 0) {
			throw new IllegalArgumentException(HEIGHT_NATURAL_NUMBER_ERROR_MSG);
		}
	}
}
