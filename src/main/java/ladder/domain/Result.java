package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final Map<Name, Bet> result = new LinkedHashMap<>();

    public Result(Map<Name, Bet> result) {
        this.result.putAll(result);
    }

    public Bet getBetByName(Name name) {
        Bet bet = result.get(name);

        if (bet == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NOT_EXIST.getMessage());
        }

        return bet;
    }

    public int size() {
        return result.size();
    }

    public Map<Name, Bet> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
