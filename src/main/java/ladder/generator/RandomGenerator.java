package ladder.generator;

import java.util.Random;

public class RandomGenerator {
	private static Random random = new Random();

	public static boolean getNextValue() {
		return random.nextBoolean();
	}
}
