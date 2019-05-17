package ladder.domain;

import java.util.Random;

public class RandomGenerator {
	private static Random random = new Random();

	public static boolean getNextValue() {
		return random.nextBoolean();
	}

	public static boolean getNextValue(Boolean previousValue) {
		return (previousValue)? false : random.nextBoolean();
	}
}
