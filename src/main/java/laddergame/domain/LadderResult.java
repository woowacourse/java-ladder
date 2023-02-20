package laddergame.domain;

import java.util.List;

public class LadderResult {

    private LadderResult() {

    }

    public static LadderResult of(Participants participants, List<String> resultNames) {
        if (participants.getSize() != resultNames.size()) {
            throw new IllegalArgumentException("인원수과 결과의 개수가 일치하지 않습니다.");
        }
        return new LadderResult();
    }
}
