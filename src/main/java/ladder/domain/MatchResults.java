package ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;

import ladder.error.ErrorMessage;

public class MatchResults {
    private static final String ALL = "all";
    private final Map<Name, Result> matchResults;

    public MatchResults(Map<Name, Result> matchResults) {
        this.matchResults = matchResults;
    }

    public Map<Name, Result> getMatchResults() {
        return matchResults;
    }

    public String findMatchResult(String name, SearchCompletionChecker checker) {
        validate(name);

        if (name.equals(ALL)) {
            return findAllResults(checker);
        }
        return findResult(checker, new Name(name)).getResult();
    }

    private void validate(String name) {
        if (name.equals(ALL)) {
            return;
        }

        if (!matchResults.containsKey(new Name(name))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_WANT_TO_KNOW_RESULT.getMessage());
        }
    }

    private String findAllResults(SearchCompletionChecker checker) {
        checker.checkAll();
        return renderResults();
    }

    private String renderResults() {
        return matchResults.entrySet().stream()
            .map(entry -> entry.getKey().getName() + " : " + entry.getValue().getResult() + "\n")
            .collect(Collectors.joining());
    }

    private Result findResult(SearchCompletionChecker checker, Name name) {
        checker.check(name);
        return matchResults.get(name);
    }
}
