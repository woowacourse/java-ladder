package domain;

public enum Stool {
	EXIST(true), EMPTY(false);

	private final boolean isExist;

	Stool(boolean isExist) {
		this.isExist = isExist;
	}

	public static Stool of(boolean isExist) {
		if (isExist)
			return Stool.EXIST;

		return Stool.EMPTY;
	}

	public boolean isExist() {
		return this.isExist;
	}
}
