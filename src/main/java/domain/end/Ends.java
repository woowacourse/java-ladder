package domain.end;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ends {
	private final List<End> ends;

	public Ends(final List<String> endNames) {
		ends = wrapEndNames(endNames);
	}

	private List<End> wrapEndNames(final List<String> endNames) {
		return endNames.stream()
			.map(End::new)
			.collect(Collectors.toList());
	}

	public int getEndsCount() {
		return ends.size();
	}

	public List<End> getEnds() {
		return Collections.unmodifiableList(ends);
	}
}
