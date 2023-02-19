package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

	private static final String DELIMITER = ",";
	private static final String PARTICIPANTS_NAMES_REQUEST_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String LADDER_HEIGHT_REQUEST_MSG = "최대 사다리 높이는 몇 개인가요?";
	private static final String HEIGHT_NOT_INT_ERROR_MSG = "사다리 높이는 정수여야 합니다.";
	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> readParticipantsNames() {
		System.out.println(PARTICIPANTS_NAMES_REQUEST_MSG);
		String line = scanner.nextLine();
		System.out.println();
		return trimNames(line.split(DELIMITER));
	}

	private static List<String> trimNames(final String[] names) {
		return Arrays.stream(names)
			.map(String::trim)
			.collect(Collectors.toList());
	}

	public static int readHeight() {
		System.out.println(LADDER_HEIGHT_REQUEST_MSG);
		String line = scanner.nextLine();
		System.out.println();
		validateIsInteger(line);
		return Integer.parseInt(line);
	}

	private static void validateIsInteger(final String line) {
		try {
			Integer.parseInt(line);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(HEIGHT_NOT_INT_ERROR_MSG);
		}
	}
}
