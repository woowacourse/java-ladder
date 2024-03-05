package domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class GameResult {

    private final HashMap<Member, Reward> gameResult;

    public GameResult() {
        this.gameResult = new LinkedHashMap<>();
    }

    public void addGameResult(Member member, Reward reward) {
        gameResult.put(member, reward);
    }

    public GameResultDto getResultByTarget(ResultTarget target) {
        if (target.isAllMembers()) {
            return getResultOfAllMembers();
        }
        return getResultOfMember(target.getValue());
    }

    private GameResultDto getResultOfAllMembers() {
        return new GameResultDto(gameResult);
    }

    private GameResultDto getResultOfMember(String memberName) {
        HashMap<Member, Reward> resolvedResult = new LinkedHashMap<>();
        Entry<Member, Reward> memberResult = gameResult.entrySet().stream()
                .filter(entry -> entry.getKey().hasSameNameWith(memberName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다."));
        resolvedResult.put(memberResult.getKey(), memberResult.getValue());
        return new GameResultDto(resolvedResult);
    }
}
