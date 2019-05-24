package ladder.model;

import java.util.Map;

public class EndResult {
    private final Map<Member, Result> endResult;

    public EndResult(final Map<Member, Result> endResult) {
        this.endResult = endResult;
    }

    public void put(Member member, Result result) {
        endResult.put(member, result);
    }

    public Result get(Member member) {
        return endResult.get(member);
    }
}
