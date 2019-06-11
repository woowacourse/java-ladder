package ladder.view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static String inputNames() {
		System.out.println(UserOutput.DEMAND_PLAYER_NAMES.getOutputMessage());
		return scanner.nextLine();
	}

	public static int inputHeight() {
		System.out.println(UserOutput.DEMAND_LADDER_HEIGHT.getOutputMessage());
		int height = scanner.nextInt();
		scanner.nextLine();
		return height;
	}

	public static String inputResults() {
		System.out.println(UserOutput.DEMAND_GAME_RESULTS.getOutputMessage());
		return scanner.nextLine();
	}

	public static String inputResult() {
		System.out.println(UserOutput.DEMAND_PLAYER_NAME_FOR_RESULT.getOutputMessage());
		return scanner.nextLine();
	}
}
