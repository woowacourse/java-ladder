package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

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
		int MIN_SIZE = 2;
		int MAX_SIZE = 10;
		if (rewards.size() < MIN_SIZE)
			throw new IllegalArgumentException(String.format("예상 결과 개수는 %d ~ %d개여야 합니다", MIN_SIZE, MAX_SIZE));
		if (rewards.size() > MAX_SIZE)
			throw new IllegalArgumentException(String.format("예상 결과 개수는 %d ~ %d개여야 합니다", MIN_SIZE, MAX_SIZE));
	}

	public List<String> getResults() {
		return results.stream()
			.map(Result::getReward)
			.collect(Collectors.toList());
	}

	public String getResult(int position) {
		return results.get(position).getReward();
	}

	public int size() {
		return results.size();
	}
}
