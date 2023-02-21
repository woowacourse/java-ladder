package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private static final String ALL_COMMAND = "all";
    private static final String NOT_EXIST_PLAYER_MESSAGE = "존재하지 않는 플레이어 이름입니다.";

    private final List<String> names;

    public Result(String value, Players players) {
        validate(value, players);
        this.names = getResultPlayerNames(value, players);
    }

    private void validate(String value, Players players) {
        if (isNotEqualsAll(value) && isNotExistName(value, players)) {
            throw new IllegalArgumentException(NOT_EXIST_PLAYER_MESSAGE);
        }
    }

    private boolean isNotEqualsAll(String value) {
        return !value.equals(ALL_COMMAND);
    }

    private boolean isNotExistName(String value, Players players) {
        List<String> filterNames = players.getPlayerNames()
                .stream().filter(value::equals)
                .collect(Collectors.toList());

        return filterNames.size() == 0;
    }

    private List<String> getResultPlayerNames(String value, Players players) {
        if (value.equals(ALL_COMMAND)) {
            return players.getPlayerNames();
        }

        return List.of(value);
    }

    public List<String> getNames() {
        return names;
    }
}
