package domain.util;

public interface PointGenerator {
	static PointGenerator getInstance(boolean isRandom) {
		if (isRandom) {
			return new RandomPointGenerator();
		}
		return new FixedPresencePointGenerator();
	}

	Point generate();
}