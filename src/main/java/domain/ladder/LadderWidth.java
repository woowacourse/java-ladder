package domain.ladder;

public class LadderWidth {
	private final static int MIN_WIDTH = 1;
	private final static String LADDER_WIDTH_TOO_SHORT_ERROR_MSG = "너비는 1 이상이여야 합니다.";
	private final int width;

	public LadderWidth(final int width) {
		validateWidth(width);
		this.width = width;
	}

	private void validateWidth(final int width) {
		if (width < MIN_WIDTH) {
			throw new IllegalArgumentException(LADDER_WIDTH_TOO_SHORT_ERROR_MSG);
		}
	}

	public int getWidth() {
		return this.width;
	}
}
