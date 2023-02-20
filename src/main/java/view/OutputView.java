package view;

import domain.util.Display;

public class OutputView {

	private final static String ERROR_PREFIX = "[ERROR] ";


	public static void printLadder(Display names, Display ladder) {
		System.out.println(names.format());
		System.out.println(ladder.format());
	}

	public static void printError(String errorMsg) {
		System.out.println(ERROR_PREFIX + errorMsg);
	}
}
