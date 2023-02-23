package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

import ladder.error.ErrorMessage;

public class Matchings {
    LinkedHashMap<Name, Result> matchings;
    LinkedHashMap<Name, Boolean> checked;

    public Matchings(LinkedHashMap<Name, Result> matchings) {
        this.matchings = matchings;
        this.checked = new LinkedHashMap<>();
        matchings.forEach(((name, result) -> checked.put(name, Boolean.FALSE)));
    }

    public String getMatchingResult(String name) {
        validate(name);

        if (name.equals("all")) {
            return findAllMatchings();
        }
        return findMatching(new Name(name));
    }

    private String findMatching(Name name) {
        checked.put(name, Boolean.TRUE);
        return matchings.get(name).getResult();
    }

    private String findAllMatchings() {
        for (Name name : matchings.keySet()) {
            checked.put(name, Boolean.TRUE);
        }

        StringBuilder stringBuilder = new StringBuilder();
        matchings.forEach((name, result) -> stringBuilder.append(name.getName())
            .append(" : ")
            .append(result.getResult())
            .append("\n"));
        return stringBuilder.toString();
    }

    public HashMap<Name, Result> getMatchings() {
        return matchings;
    }

    private void validate(String name) {
        Name targetName = new Name(name);
        if (!name.equals("all") && !matchings.containsKey(targetName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_WANT_TO_KNOW.getMessage());
        }
    }

    public boolean isAllChecked() {
        return checked.values().stream().allMatch(aBoolean -> aBoolean == Boolean.TRUE);
    }
}
