package domain;

import java.util.ArrayList;
import java.util.List;

import exception.Error;

public class Results {
	private static final int MIN_RESULTS_SIZE_INCLUSIVE = 2;
	private static final int MAX_RESULTS_SIZE_INCLUSIVE = 10;

	private final List<Result> results;

	private Results(List<Result> results) {
		this.results = results;
	}

	public static Results from(List<String> sequences) {
		validateSize(sequences);
		List<Result> resultList = new ArrayList<>();
		for (String sequence : sequences) {
			resultList.add(new Result(sequence));
		}
		return new Results(resultList);
	}

	private static void validateSize(List<String> sequences) {
		if (sequences.size() < MIN_RESULTS_SIZE_INCLUSIVE)
			throw new IllegalArgumentException(Error.RESULTS_FROM_2_TO_10.getMessage());
		if (sequences.size() > MAX_RESULTS_SIZE_INCLUSIVE)
			throw new IllegalArgumentException(Error.RESULTS_FROM_2_TO_10.getMessage());
	}

	public int size() {
		return results.size();
	}
}
