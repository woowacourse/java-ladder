package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {

    private final HashMap<Member, Result> gameResult;

    public GameResult() {
        this.gameResult = new LinkedHashMap<>();
    }

    public void addGameResult(Member member, Result result) {
        gameResult.put(member, result);
    }

    public Map<Member, Result> getResultByTarget(ResultTarget target) {
        if (target.isAllMembers()) {
            return getResultOfAllMember();
        }
        Member member = new Member(target.getName());
        Result result = getResultByMemberName(target.getName());
        return new HashMap<>() {{
            put(member, result);
        }};
    }

    // TODO: 두 메서드 private 으로 변경 <- test 수정
    public Result getResultByMemberName(String name) {
        return gameResult.entrySet().stream()
                .filter(memberResult -> memberResult.getKey().getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다."))
                .getValue();
    }

    public Map<Member, Result> getResultOfAllMember() {
        return Collections.unmodifiableMap(gameResult);
    }
}
