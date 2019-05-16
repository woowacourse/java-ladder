package laddergame.domain;

public class Point {
	// TODO Point의 이름을 변경하는 것 고려
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
