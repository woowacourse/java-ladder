package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 우가
 * @version 1.0.0
 * @Created by 우가 on 2023/02/22
 */
public class Result {

    private static final String ALL_SEARCH_CONDITION = "all";
    private static final String NON_EXIST_PLAYER_MESSAGE = "참여자가 존재하지 않습니다.";
    private static final String NOT_SAME_SIZE_MESSAGE = "실행결과 수는 참여자 수와 같아야합니다.";

    private final Map<String, String> result;

    public Result(final Players players, final List<String> results) {
        List<String> names = players.getNames();
        validateSize(names, results);
        result = makeResult(names, results);
    }

    private Map<String, String> makeResult(final List<String> names, final List<String> results) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i), results.get(i));
        }
        return map;
    }

    private void validateSize(final List<String> playerNames, final List<String> results) {
        if (playerNames.size() != results.size()) {
            throw new IllegalArgumentException(NOT_SAME_SIZE_MESSAGE);
        }
    }

    public void isExistPlayerName(final String input) {
        validateName(input);
    }

    private void validateName(final String input) {
        if (input.equals(ALL_SEARCH_CONDITION)) {
            return;
        }
        if (!result.containsKey(input)) {
            throw new IllegalArgumentException(NON_EXIST_PLAYER_MESSAGE);
        }
    }

    public Map<String, String> resultByName(final String playerName) {
        if (playerName.equals(ALL_SEARCH_CONDITION)) {
            return result;
        }
        HashMap<String, String> searchNameResult = new HashMap<>();
        searchNameResult.put(playerName, result.get(playerName));
        return searchNameResult;
    }
}
