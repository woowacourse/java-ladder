package ladder.domain;

import java.util.LinkedHashMap;

import ladder.error.ErrorMessage;

public class MatchResults {
    LinkedHashMap<Name, Result> matchResults;
    LinkedHashMap<Name, Boolean> checked;

    public MatchResults(LinkedHashMap<Name, Result> matchResults) {
        this.matchResults = matchResults;
        this.checked = new LinkedHashMap<>();
        matchResults.forEach(((name, result) -> checked.put(name, Boolean.FALSE)));
    }

    public String findMatchResult(String name) {
        validate(name);

        if (name.equals("all")) {
            return findAllResults();
        }
        return findResult(new Name(name));
    }

    private void validate(String name) {
        if (name.equals("all")) {
            return;
        }

        Name targetName = new Name(name);
        if (!matchResults.containsKey(targetName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_WANT_TO_KNOW.getMessage());
        }
    }

    private String findAllResults() {
        checkAll();
        return renderResults();
    }

    private void checkAll() {
        for (Name name : matchResults.keySet()) {
            checked.put(name, Boolean.TRUE);
        }
    }

    private String renderResults() {
        StringBuilder stringBuilder = new StringBuilder();
        matchResults.forEach((name, result) -> stringBuilder.append(name.getName())
            .append(" : ")
            .append(result.getResult())
            .append("\n"));
        return stringBuilder.toString();
    }

    private String findResult(Name name) {
        checked.put(name, Boolean.TRUE);
        return matchResults.get(name).getResult();
    }

    public boolean isAllChecked() {
        return checked.values().stream().allMatch(aBoolean -> aBoolean == Boolean.TRUE);
    }
}
