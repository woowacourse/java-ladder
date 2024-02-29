package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GameResult {

    private final HashMap<Member, Result> gameResult;

    public GameResult() {
        this.gameResult = new LinkedHashMap<>();
    }

    public void addGameResult(Member member, Result result) {
        gameResult.put(member, result);
    }

    public Map<String, Result> getResultByTarget(ResultTarget target) {
        if (target.isAllMembers()) {
            return getResultOfAllMember();
        }
        String memberName = target.getName();
        Result result = getResultByMemberName(target.getName());
        return new LinkedHashMap<>() {{
            put(memberName, result);
        }};
    }

    private Result getResultByMemberName(String name) {
        return gameResult.entrySet().stream()
                .filter(memberResult -> memberResult.getKey().getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다."))
                .getValue();
    }

    private Map<String, Result> getResultOfAllMember() {
        Map<String, Result> resolvedResult = new LinkedHashMap<>();
        for (Entry<Member, Result> memberResult : gameResult.entrySet()) {
            String memberName = memberResult.getKey().getName();
            Result result = memberResult.getValue();
            resolvedResult.put(memberName, result);
        }
        return resolvedResult;
    }
}
