package laddergame.domain;

import laddergame.domain.gameelements.people.Name;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Result;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RowLine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Connection.CONNECTED;

public class LadderGame {
    private final Map<Name, Result> playerGameResult;

    LadderGame(People people, Ladder ladder, Results results) {
        validateSameLength(people, results);
        List<Result> gameResult = initializeGameResult(ladder, results);

        playerGameResult = new LinkedHashMap<>();
        for (int i = 0; i < people.getNames().size(); i++) {
            playerGameResult.put(people.getNames().get(i), gameResult.get(i));
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
        List<Integer> resultIdx = moveByLadder(ladder, results.getResults().size());
        return resultIdx.stream()
                .map(idx -> results.getResults().get(idx))
                .toList();
    }

    List<Integer> moveByLadder(Ladder ladder, int peopleNumber) {
        List<Integer> playerPositions = IntStream.range(0, peopleNumber)
                .boxed()
                .toList();

        for (RowLine rowLine : ladder.getRowLines()) {
            playerPositions = moveByRowLine(rowLine, playerPositions);
        }

        return playerPositions;
    }

    private List<Integer> moveByRowLine(RowLine rowLine, List<Integer> playerPositions) {
        return playerPositions.stream()
                .mapToInt(playerPosition -> moveByConnection(playerPosition, rowLine.getConnections()))
                .boxed()
                .toList();
    }

    private int moveByConnection(int playerPosition, List<Connection> connections) {
        int leftConnectionIdx = playerPosition - 1;
        int rightConnectionIdx = playerPosition;

        if (leftConnectionIdx >= 0
                && connections.get(leftConnectionIdx) == CONNECTED) {
            return playerPosition - 1;
        }

        if ((rightConnectionIdx < connections.size())
                && connections.get(rightConnectionIdx) == CONNECTED) {
            return playerPosition + 1;
        }

        return playerPosition;
    }

    public Map<Name, Result> getPlayerGameResult() {
        return playerGameResult;
    }
}
