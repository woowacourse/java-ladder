package domain;

public class LadderHeight {
	private static final int MIN_HEIGHT = 1;
	private static final int MAX_HEIGHT = 10;
	private static final String LADDER_HEIGHT_NOT_IN_RANGE_MSG = "사다리의 높이는 1이상 10이하여야 합니다.";
	private final int height;

	public LadderHeight(final int height) {
		validateHeight(height);
		this.height = height;
	}

	private void validateHeight(final int number) {
		if (number < MIN_HEIGHT || number > MAX_HEIGHT) {
			throw new IllegalArgumentException(LADDER_HEIGHT_NOT_IN_RANGE_MSG);
		}
	}

	public int getHeight() {
		return height;
	}
}
