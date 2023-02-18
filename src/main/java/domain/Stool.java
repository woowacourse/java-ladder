package domain;

import java.util.Arrays;

public enum Stool {
	EXIST(true), EMPTY(false);

	private final boolean isExist;

	Stool(boolean isExist) {
		this.isExist = isExist;
	}

	public static Stool of(boolean isExist) {
		return Arrays.stream(Stool.values())
			.filter(stool -> stool.isExist == isExist)
			.findAny()
			.orElseThrow();
	}

	public boolean isStool() {
		return this.isExist;
	}
}
