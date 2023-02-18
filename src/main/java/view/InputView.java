package view;

import java.util.List;
import java.util.Scanner;

import exception.Error;

public class InputView {
	public List<String> readNames() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return List.of(scanner.nextLine().split(","));
	}

	private final Scanner scanner = new Scanner(System.in);

	public int readHeight() {
		try {
			System.out.println("\n최대 사다리 높이는 몇 개인가요?");
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Error.HEIGHT_ONLY_NUMBER.getMessage());
		}
	}
}
