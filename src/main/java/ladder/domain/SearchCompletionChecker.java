package ladder.domain;

import java.util.Map;

public class SearchCompletionChecker {
    Map<Name, Boolean> checked;

    public SearchCompletionChecker(Map<Name, Result> matchResults, Map<Name, Boolean> checked) {
        this.checked = checked;
        matchResults.keySet().forEach(name -> checked.put(name, Boolean.FALSE));
    }

    public void checkAll() {
        checked.replaceAll((n, v) -> Boolean.TRUE);
    }

    public void check(Name name) {
        checked.replace(name, Boolean.TRUE);
    }

    public boolean isAllChecked() {
        return checked.values().stream().allMatch(Boolean::booleanValue);
    }
}
