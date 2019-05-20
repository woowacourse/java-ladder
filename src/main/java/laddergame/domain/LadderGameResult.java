package laddergame.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<Tag, Tag> result;

    public LadderGameResult(final Map<Tag, Tag> result) {
        this.result = result;
    }

    public Tag prize(final Tag member) {
        if (!result.containsKey(member)) {
            throw new IllegalArgumentException("해당 이름은 존재하지 않습니다");
        }
        return result.get(member);
    }

    public Map<Tag, Tag> allPrizes() {
        return result;
    }
}
