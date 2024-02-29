package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import domain.ladder.Bar;
import domain.ladder.Floor;
import domain.ladder.Ladder;

public class RandomLadderGenerator {

	private final RandomGenerator random;

	public RandomLadderGenerator(RandomGenerator random) {
		this.random = random;
	}

	public Ladder generate(int ladderHeight, int playerCount) {
		List<Floor> floors = new ArrayList<>();
		for (int i = 0; i < ladderHeight; i++) {
			floors.add(generateFloor(playerCount));
		}

		return new Ladder(floors);
	}

	private Floor generateFloor(int playerCount) {
		List<Bar> bars = new ArrayList<>();

		Bar previous = Bar.NOT_CONNECTED;
		for (int i = 0; i < playerCount - 1; i++) {
			Bar current = createBar(previous);
			bars.add(current);
			previous = current;
		}
		bars.add(createLastBar(previous));

		return new Floor(bars);
	}

	private Bar createBar(Bar previous) {
		if (previous.isConnectedToRight()) {
			return Bar.CONNECTED_TO_LEFT;
		}

		boolean canConnect = random.nextBoolean();
		if (canConnect) {
			return Bar.CONNECTED_TO_RIGHT;
		}

		return Bar.NOT_CONNECTED;
	}

	private Bar createLastBar(Bar previous) {
		if (previous.isConnectedToRight()) {
			return Bar.CONNECTED_TO_LEFT;
		}
		return Bar.NOT_CONNECTED;
	}
}
