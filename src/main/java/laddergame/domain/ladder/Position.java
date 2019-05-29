package laddergame.domain.ladder;

public class Position {
	private static final int MIN_NUM_OF_POSITION = 0;

	private final int row;
	private final int column;

	private Position(final int row, final int column) {
		if (row <= MIN_NUM_OF_POSITION || column <= MIN_NUM_OF_POSITION) {
			throw new IllegalArgumentException("잘못된 행,열 정보를 입력했습니다");
		}
		this.row = row;
		this.column = column;
	}

	public static Position of(final int row, final int column) {
		return new Position(row, column);
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
}
