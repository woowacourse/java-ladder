package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exception.Error;

public class Results {
	private static final int MIN_RESULTS_SIZE_INCLUSIVE = 2;
	private static final int MAX_RESULTS_SIZE_INCLUSIVE = 10;

	private final List<Result> results;

	private Results(List<Result> results) {
		this.results = results;
	}

	public static Results from(List<String> rewards) {
		validateSize(rewards);
		List<Result> resultList = new ArrayList<>();
		for (String reward : rewards) {
			resultList.add(new Result(reward));
		}
		return new Results(resultList);
	}

	private static void validateSize(List<String> rewards) {
		if (rewards.size() < MIN_RESULTS_SIZE_INCLUSIVE)
			throw new IllegalArgumentException(Error.RESULTS_FROM_2_TO_10.getMessage());
		if (rewards.size() > MAX_RESULTS_SIZE_INCLUSIVE)
			throw new IllegalArgumentException(Error.RESULTS_FROM_2_TO_10.getMessage());
	}

	public List<String> getResults() {
		return results.stream()
			.map(Result::getSequence)
			.collect(Collectors.toList());
	}

	public String getResult(int position) {
		return results.get(position).getSequence();
	}

	public int size() {
		return results.size();
	}
}
