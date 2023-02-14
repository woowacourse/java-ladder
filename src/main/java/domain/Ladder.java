package domain;

public class Ladder {
	private final int height;

	public Ladder(int height) {
		validate(height);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	private void validate(int height) {
		if (height < 1 || height > 100)
			throw new IllegalArgumentException();
	}
}
