package laddergame.domain;

import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Result;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Connection;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RowLine;

import java.util.List;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Connection.CONNECTED;

public class LadderGame {
    private final List<String> gameResult;

    LadderGame(People people, Ladder ladder, Results results) {
        validateSameLength(people, results);
        this.gameResult = initializeGameResult(ladder, results);
    }

    private void validateSameLength(People people, Results results) {
        if (people.getNames().size() != results.getResults().size()) {
            throw new IllegalArgumentException("게임 실행 결과와 게임 참여자의 수가 같지 않습니다");
        }
    }

    private List<String> initializeGameResult(Ladder ladder, Results results) {
        List<Result> gameResults = results.getResults();
        List<Integer> resultIdx = moveByLadder(ladder, gameResults.size());
        return resultIdx.stream()
                .map(idx -> gameResults.get(idx).getResult())
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

    public List<String> getGameResult() {
        return gameResult;
    }
}
