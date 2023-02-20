package domain;

public class LadderHeight {
	private final static String HEIGHT_ERROR_MSG = "사다리의 높이는 1 이상이어야 합니다.";

	private final int height;

	public LadderHeight(final int height) {
		validateHeight(height);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	private void validateHeight(final int height) {
		if (height < 1) {
			throw new IllegalArgumentException(HEIGHT_ERROR_MSG);
		}
	}
}
