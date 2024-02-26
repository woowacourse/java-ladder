package domain;

import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Names;
import domain.result.Result;
import domain.result.Results;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class GameResult {
    private final Map<Name, Result> matchResult;

    public GameResult(Names names, Results results, Ladder ladder) {
        validate(names, results, ladder);
        this.matchResult = ladder.getMatchResult(names, results);
    }

    private void validate(Names names, Results results, Ladder ladder) {
        if (names == null || results == null || ladder == null) {
            throw new IllegalArgumentException("null 객체를 사용해 LadderGame을 생성할 수 없습니다.");
        }
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("이름과 결과의 개수는 같아야 합니다.\n"
                    + "이름의 개수 : " + names.size() + ", 결과의 개수 : " + results.size());
        }
        if (names.size() != ladder.getLegSize()) {
            throw new IllegalArgumentException("이름의 개수와 사다리의 다리 개수는 같아야 합니다.\n"
                    + "이름의 개수 : " + names.size() + ", 다리 개수 : " + ladder.getLegSize());
        }
    }

    public Result getResult(Name name) {
        return Optional.ofNullable(matchResult.get(name))
                .orElseThrow(() -> new IllegalArgumentException(name.getName() + "과 매칭되는 결과가 존재하지 않습니다."));
    }

    public Map<Name, Result> getAllResult() {
        return Collections.unmodifiableMap(matchResult);
    }
}
