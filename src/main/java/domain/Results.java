package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(final List<String> resultsName, final int usersNumber) {
        hasSameNumberWithUsersNumber(resultsName, usersNumber);
        results = initResults(resultsName);
    }

    public List<String> getResultsName() {
        final List<String> resultsName = new ArrayList<>();
        for (final Result result : results) {
            resultsName.add(result.getName());
        }
        return resultsName;
    }

    private void hasSameNumberWithUsersNumber(final List<String> resultsName, final int usersNumber) {
        if (resultsName.size() != usersNumber) {
            throw new IllegalArgumentException();
        }
    }

    private List<Result> initResults(List<String> resultsName) {
        final List<Result> results = new ArrayList<>();
        for (final String resultName : resultsName) {
            results.add(new Result(resultName));
        }
        return results;
    }
}
