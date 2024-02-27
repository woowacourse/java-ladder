package laddergame.domain;

import laddergame.domain.gameelements.Element;
import laddergame.domain.gameelements.Elements;
import laddergame.domain.ladder.Ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Map<Element, Element> playerGameResult;

    public LadderGame(Elements people, Ladder ladder, Elements results) {
        validateSameLength(people, results);
        List<Element> gameResults = initializeGameResult(ladder, results);

        playerGameResult = new LinkedHashMap<>();
        for (int i = 0; i < people.getElements().size(); i++) {
            playerGameResult.put(people.getElements().get(i), gameResults.get(i));
        }
    }

    public Element findPlayerResult(Element playerName) {
        if (!(playerGameResult.containsKey(playerName))) {
            throw new IllegalArgumentException("참여하지 않은 플레이어의 이름을 조회했습니다.");
        }

        return playerGameResult.get(playerName);
    }

    private void validateSameLength(Elements people, Elements results) {
        if (people.getElements().size() != results.getElements().size()) {
            throw new IllegalArgumentException("게임 실행 결과와 게임 참여자의 수가 같지 않습니다");
        }
    }

    private List<Element> initializeGameResult(Ladder ladder, Elements results) {
        List<Integer> resultIdx = ladder.move(results.getElements().size());
        return resultIdx.stream()
                .map(idx -> results.getElements().get(idx))
                .toList();
    }

    public Map<Element, Element> getPlayerGameResult() {
        return playerGameResult;
    }
}
