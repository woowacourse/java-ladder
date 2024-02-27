package laddergame.domain;

import laddergame.domain.gameelements.people.Name;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Result;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Map<Name, Result> playerGameResult;

    public LadderGame(People people, Ladder ladder, Results results) {
        validateSameLength(people, results);
        List<Result> gameResults = initializeGameResult(ladder, results);

        playerGameResult = new LinkedHashMap<>();
        for (int i = 0; i < people.getNames().size(); i++) {
            playerGameResult.put(people.getNames().get(i), gameResults.get(i));
        }
    }

    public Result findPlayerResult(Name playerName) {
        if (!(playerGameResult.containsKey(playerName))) {
            throw new IllegalArgumentException("참여하지 않은 플레이어의 이름을 조회했습니다.");
        }

        return playerGameResult.get(playerName);
    }

    private void validateSameLength(People people, Results results) {
        if (people.getNames().size() != results.getResults().size()) {
            throw new IllegalArgumentException("게임 실행 결과와 게임 참여자의 수가 같지 않습니다");
        }
    }

    private List<Result> initializeGameResult(Ladder ladder, Results results) {
        List<Integer> resultIdx = ladder.move(results.getResults().size());
        return resultIdx.stream()
                .map(idx -> results.getResults().get(idx))
                .toList();
    }

    public Map<Name, Result> getPlayerGameResult() {
        return playerGameResult;
    }
}
