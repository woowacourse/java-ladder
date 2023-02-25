package domain;

import java.util.ArrayList;
import java.util.List;

import static exception.ErrorMessage.RESULT_NUMBERS_NOT_SAME_WITH_USER_NUMBERS;

public class Results {

    private final List<Result> results;

    public Results(final List<String> resultNames, final int userNumbers) {
        hasSameNumberWithUserNumbers(resultNames, userNumbers);
        results = initResults(resultNames);
    }

    public List<String> getResultNames() {
        final List<String> resultNames = new ArrayList<>();
        results.forEach(result -> resultNames.add(result.getName()));
        return List.copyOf(resultNames);
    }

    private void hasSameNumberWithUserNumbers(final List<String> resultNames, final int userNumbers) {
        if (resultNames.size() != userNumbers) {
            throw new IllegalArgumentException(RESULT_NUMBERS_NOT_SAME_WITH_USER_NUMBERS.getMessage());
        }
    }

    private List<Result> initResults(final List<String> resultNames) {
        final List<Result> results = new ArrayList<>();
        resultNames.forEach(resultName -> results.add(new Result(resultName)));
        return results;
    }
}
