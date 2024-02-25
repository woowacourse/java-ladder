package domain;

import domain.ladder.Ladder;
import domain.player.Names;
import domain.result.Results;

public class LadderGame {
    public LadderGame(Names names, Results results, Ladder ladder) {
        validate(names, results, ladder);
    }

    private void validate(Names names, Results results, Ladder ladder) {
        if (names == null || results == null || ladder == null) {
            throw new IllegalArgumentException("null 객체를 사용해 LadderGame을 생성할 수 없습니다.");
        }
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("이름과 결과의 개수는 같아야 합니다.\n"
                    + "이름의 개수 : " + names.size() + ", 결과의 개수 : " + results.size());
        }
        if (names.size() != ladder.width() + 1) {
            throw new IllegalArgumentException("이름의 개수와 사다리의 다리 개수는 같아야 합니다.\n"
                    + "이름의 개수 : " + names.size() + ", 다리 개수 : " + ladder.width() + 1);
        }
    }
}
