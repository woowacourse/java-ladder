package laddergame.domain.ladder;

public class Point {
	private final boolean bridge;

	public Point(boolean bridge) {
		this.bridge = bridge;
	}

	public boolean hasBridge() {
		return this.bridge;
	}

	@Override
	public String toString() {
		return bridge ? "-----" : "     ";
	}
}
