package domain;

import java.util.Collections;
import java.util.List;

public record HorizontalLineStatus(List<FloorConnectionStatus> placedStatuses) {

	public List<FloorConnectionStatus> placedStatuses() {
		return Collections.unmodifiableList(placedStatuses);
	}
}
