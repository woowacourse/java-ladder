package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import domain.Bar;

public class LadderFloorGenerator {

	private final BooleanSupplier supplier;

	public LadderFloorGenerator(BooleanSupplier supplier) {
		this.supplier = supplier;
	}

	public List<Bar> generate(int size) {
		List<Bar> bars = new ArrayList<>();

		Bar previous = Bar.NOT_CONNECTED;
		for (int order = 0; order < size - 1; order++) {
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

		boolean canConnect = supplier.getAsBoolean();
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