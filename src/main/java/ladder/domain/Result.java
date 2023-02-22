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

    private Map<String, String> result;

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
            throw new IllegalArgumentException("실행결과 수는 참여자 수와 같아야합니다.");
        }
    }

    public void isExistPlayerName(final String input) {
        validateName(input);
    }

    private void validateName(final String input) {
        if (!result.containsKey(input)) {
            throw new IllegalArgumentException("참여자가 존재하지 않습니다.");
        }
    }

    public String resultByName(final String playerName) {
        return result.get(playerName);
    }
}
