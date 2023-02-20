package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
	private final List<Result> results;

	private Results(List<Result> results) {
		this.results = results;
	}

	public static Results from(List<String> sequences) {
		List<Result> resultList = new ArrayList<>();
		for (String sequence : sequences) {
			resultList.add(new Result(sequence));
		}
		return new Results(resultList);
	}

	public int size() {
		return results.size();
	}
}
