package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GameResult {

    private final HashMap<Member, Result> gameResult;

    public GameResult() {
        this.gameResult = new HashMap<>();
    }

    public void addGameResult(Member member, Result result) {
        gameResult.put(member, result);
    }

    public Result getResultByMemberName(String name) {
        for (Entry<Member, Result> memberResult : gameResult.entrySet()) {
            if (memberResult.getKey().getName().equals(name)) {
                return memberResult.getValue();
            }
        }
        throw new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다."); // TODO: 다른 방법?
    }

    public Map<Member, Result> getResultOfAllMember() {
        return Collections.unmodifiableMap(gameResult);
    }
}
