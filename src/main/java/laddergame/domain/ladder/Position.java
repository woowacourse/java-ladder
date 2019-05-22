package laddergame.domain.ladder;

public class Position {
	private final int row;
	private final int column;

	private Position(final int row, final int column) {
		if (row <= 0 || column <= 0) {
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
