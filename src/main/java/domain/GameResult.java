package domain;

import java.util.Map;

public class GameResult {

    private final Map<String, String> gameResult;

    public GameResult(final Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String findResult(final String name) {
        validateCorrectName(name);

        if (name.equals("all")) {
            return String.join(",", this.gameResult.values());
        }
        return this.gameResult.get(name);
    }

    private void validateCorrectName(final String name) {
        if (!gameResult.containsKey(name)) {
            throw new IllegalArgumentException("해당 되는 이름을 가진 사람은 참여하지 않았습니다.");
        }
    }

    public Map<String, String> getGameResult() {
        return this.gameResult;
    }
}
