package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import domain.FloorConnectionStatus;

public class LadderFloorGenerator {

	private final BooleanSupplier supplier;

	public LadderFloorGenerator(BooleanSupplier supplier) {
		this.supplier = supplier;
	}

	public List<FloorConnectionStatus> generate(int size) {
		List<FloorConnectionStatus> floor = new ArrayList<>();

		FloorConnectionStatus previous = FloorConnectionStatus.NOT_CONNECTED;
		for (int order = 0; order < size - 1; order++) {
			FloorConnectionStatus current = getConnection(previous);
			floor.add(current);
			previous = current;
		}
		floor.add(getLastConnection(previous));

		return floor;
	}

	private FloorConnectionStatus getConnection(FloorConnectionStatus previous) {
		if (previous.isConnectedToRight()) {
			return FloorConnectionStatus.CONNECTED_TO_LEFT;
		}

		boolean canConnect = supplier.getAsBoolean();
		if (canConnect) {
			return FloorConnectionStatus.CONNECTED_TO_RIGHT;
		}

		return FloorConnectionStatus.NOT_CONNECTED;
	}

	private FloorConnectionStatus getLastConnection(FloorConnectionStatus previous) {
		if (previous.isConnectedToRight()) {
			return FloorConnectionStatus.CONNECTED_TO_LEFT;
		}
		return FloorConnectionStatus.NOT_CONNECTED;
	}
}
