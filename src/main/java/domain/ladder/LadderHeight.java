package domain.ladder;

public record LadderHeight(int value) {

	private static final int MIN_HEIGHT = 1;
	private static final int MAX_HEIGHT = 10;

	public LadderHeight {
		validateHeight(value);
	}

	private void validateHeight(int height) {
		if (isHeightOutOfRange(height)) {
			throw new IllegalArgumentException("사다리의 높이는 1 이상 10 이하여야 합니다.");
		}
	}

	private boolean isHeightOutOfRange(int height) {
		return height < MIN_HEIGHT || height > MAX_HEIGHT;
	}
}
