package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private static final String ALL_COMMAND = "all";

    private final List<String> names;

    public Result(String value, Players players) {
        validate(value, players);
        this.names = provideName(value, players);
    }

    private void validate(String value, Players players) {
        if (isNotAll(value) && isNotNameInPlayer(value, players)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어 이름입니다.");
        }
    }

    private boolean isNotAll(String value) {
        return !value.equals(ALL_COMMAND);
    }

    private boolean isNotNameInPlayer(String value, Players players) {
        List<String> filterNames = players.getPlayerNames()
                .stream().filter(value::equals)
                .collect(Collectors.toList());

        System.out.println(players.getPlayerNames());
        System.out.println(players.getPlayerNames().stream().filter(value::equals).collect(Collectors.toList()));

        return filterNames.size() == 0;
    }

    private List<String> provideName(String value, Players players) {
        if (value.equals(ALL_COMMAND)) {
            return players.getPlayerNames();
        }

        return List.of(value);
    }

    public List<String> getNames() {
        return names;
    }
}
