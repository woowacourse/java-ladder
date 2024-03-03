package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class GameResult {

    private final HashMap<Member, Result> gameResult;

    public GameResult() {
        this.gameResult = new LinkedHashMap<>();
    }

    public void addGameResult(Member member, Result result) {
        gameResult.put(member, result);
    }

    public GameResultDto getResultByTarget(ResultTarget target) {
        if (target.isAllMembers()) {
            return getResultOfAllMembers();
        }
        return getResultOfMember(target.getValue());
    }

    private GameResultDto getResultOfAllMembers() { // TODO: stream
        HashMap<Member, Result> resolvedResult = new LinkedHashMap<>();
        for (Entry<Member, Result> memberResult : gameResult.entrySet()) {
            Member member = memberResult.getKey();
            Result result = memberResult.getValue();
            resolvedResult.put(member, result);
        }
        return new GameResultDto(resolvedResult);
    }

    private GameResultDto getResultOfMember(String memberName) {
        HashMap<Member, Result> resolvedResult = new LinkedHashMap<>();
        Entry<Member, Result> memberResult = gameResult.entrySet().stream()
                .filter(entry -> entry.getKey().hasSameNameWith(memberName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다."));
        resolvedResult.put(memberResult.getKey(), memberResult.getValue());
        return new GameResultDto(resolvedResult);
    }
}
