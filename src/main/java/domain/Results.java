package domain;

import exception.EmptyInputException;
import exception.InvalidResultsCount;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private static final String SPLIT_NAME_DELIMITER = ",";

    private final List<Result> results = new ArrayList<>();

    public Results(String results, int maxResultCount) {
        validate(results, maxResultCount);
        addAllResult(results);
    }

    private void validate(String results, int maxResultCount) {
        if (StringUtil.isNullOrBlank(results)) {
            throw new EmptyInputException();
        }
        List<String> splitResults = splitResults(results);
        if (isValidCount(splitResults, maxResultCount)) {
            throw new InvalidResultsCount();
        }
    }

    private List<String> splitResults(String results) {
        return List.of(results.split(SPLIT_NAME_DELIMITER));
    }

    private boolean isValidCount(List<String> results, int maxResultCount) {
        return results.size() != maxResultCount;
    }

    private void addAllResult(String results) {
        splitResults(results)
                .forEach((result) -> this.results.add(new Result(result)));
    }

    public List<Result> getResult() {
        return results;
    }

    public Result getByIndex(int index) {
        return results.get(index);
    }
}
