package domain;

import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prize;
import domain.result.Prizes;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class GameResult {
    private final Map<Name, Prize> matchResult;

    public GameResult(LadderGame ladderGame) {
        Names names = ladderGame.getNames();
        Prizes prizes = ladderGame.getResult();
        Ladder ladder = ladderGame.getLadder();
        this.matchResult = ladder.getMatchResult(names, prizes);
    }

    public Prize getResult(Name name) {
        return Optional.ofNullable(matchResult.get(name))
                .orElseThrow(() -> new IllegalArgumentException(name.getName() + "과 매칭되는 결과가 존재하지 않습니다."));
    }

    public Map<Name, Prize> getAllResult() {
        return Collections.unmodifiableMap(matchResult);
    }
}
