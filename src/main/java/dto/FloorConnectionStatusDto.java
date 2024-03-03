package dto;

import java.util.Collections;
import java.util.List;

public record FloorConnectionStatusDto(List<Boolean> connections) {

	public List<Boolean> connections() {
		return Collections.unmodifiableList(connections);
	}
}
