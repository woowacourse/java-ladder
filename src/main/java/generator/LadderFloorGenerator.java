package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.random.RandomGenerator;

import domain.Bar;

public class LadderFloorGenerator {

	private final RandomGenerator random;

	public LadderFloorGenerator(RandomGenerator random) {
		this.random = random;
	}

	public List<Bar> generate(int floorWidth) {
		List<Bar> bars = new ArrayList<>();

		Bar previous = Bar.NOT_CONNECTED;
		for (int order = 0; order < floorWidth - 1; order++) {
			Bar current = getConnection(previous);
			bars.add(current);
			previous = current;
		}
		bars.add(getLastConnection(previous));

		return bars;
	}

	private Bar getConnection(Bar previous) {
		if (previous.isConnectedToRight()) {
			return Bar.CONNECTED_TO_LEFT;
		}

		boolean canConnect = random.nextBoolean();
		if (canConnect) {
			return Bar.CONNECTED_TO_RIGHT;
		}

		return Bar.NOT_CONNECTED;
	}

	private Bar getLastConnection(Bar previous) {
		if (previous.isConnectedToRight()) {
			return Bar.CONNECTED_TO_LEFT;
		}
		return Bar.NOT_CONNECTED;
	}
}