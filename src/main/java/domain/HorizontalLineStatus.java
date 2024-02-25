package domain;

import java.util.Collections;
import java.util.List;

public record HorizontalLineStatus(List<Bar> bars) {

	public List<Bar> bars() {
		return Collections.unmodifiableList(bars);
	}
}
