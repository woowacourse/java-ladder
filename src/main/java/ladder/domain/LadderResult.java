package ladder.domain;

import ladder.domain.item.Person;
import ladder.domain.item.WinningItem;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<Person, WinningItem> result;

    public LadderResult(Map<Person, WinningItem> result) {
        this.result = new HashMap<>(result);
    }

    public WinningItem findWinningItemByPersonName(String personName) {
        return result.get(new Person(personName));
    }

    public Map<String, String> getTotalResult() {
        return result.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getName(), entry -> entry.getValue().getName()));
    }
}
