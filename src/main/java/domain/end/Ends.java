package domain.end;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ends {
	private static final String END_COUNT_INVALID_ERROR_MSG = "결과의 수가 참가자 수와 다릅니다.";
	private final List<End> ends;

	public Ends(final List<String> endNames, final int count) {
		validateCount(endNames, count);
		ends = wrapEndNames(endNames);
	}

	private void validateCount(final List<String> endNames, final int count) {
		if (endNames.size() != count) {
			throw new IllegalArgumentException(END_COUNT_INVALID_ERROR_MSG);
		}
	}

	private List<End> wrapEndNames(final List<String> endNames) {
		return endNames.stream()
			.map(End::new)
			.collect(Collectors.toList());
	}

	public List<End> getEnds() {
		return Collections.unmodifiableList(ends);
	}
}
