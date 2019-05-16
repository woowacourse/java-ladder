package laddergame;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.PlayerBuilder;
import laddergame.domain.player.Players;
import laddergame.domain.result.Result;
import laddergame.domain.result.ResultBuilder;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {
    public static void main(String[] args) {
        // players 를 입력받고 생성한다.
        Players players = setPlayers();
        // 결과를 입력받고 생성한다.
        // 플레이어의 수와 다르면 다시 입력 받는다.
        Results results = setResults(players);
        // 높이를 입력받는다.
        LadderHeight ladderHeight = setLadderHeight();
        //사다리 생성
        Ladder ladder = new Ladder(ladderHeight.getLadderHeight(), players.getTotalPlayers());
        ladder.connectBridgesRandomly(100);
        // 플레이어, 사다리, 결과를 출력한다.
        OutputView.showPlayers(players);
        OutputView.showLadder(ladder);
        OutputView.showResults(results);
        // 찾고싶은 사람의 이름을 입력받는다.
        // 그 사람에 대한 결과를 출력한다.
        while (print(players, results, ladder)) {
        };
        // all 을 입력할 시 모든 결과를 한번에 출력한다.
        for (int i = 0; i < players.getTotalPlayers(); i++) {
            System.out.print(players.getNameOfIndex(i));
            System.out.println("\t:\t" + results.getResult(ladder.findResultIndex(i + 1) - 1));
        }
    }

    private static Players setPlayers() {
        try {
            return new PlayerBuilder(InputView.inputPlayers()).buildPlayers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setPlayers();
        }
    }

    private static Results setResults(Players players) {
        try {
            Results results = new ResultBuilder(InputView.inputResults()).makeResults();
            checkPlayersWithResults(players, results);
            return results;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setResults(players);
        }
    }


    private static LadderHeight setLadderHeight() {
        try {
            return new LadderHeight(InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLadderHeight();
        }
    }

    private static void checkPlayersWithResults(Players players, Results results) {
        if (results.matchPlayersCount(players.getTotalPlayers())) {
            throw new IllegalArgumentException("개수가 같아야됩니다(플레이어, 결과)");
        }
    }

    private static boolean print(Players players, Results results, Ladder ladder) {
        try {
            String command = InputView.inputCommand();
            if (command.equals("all")) {
                return false;
            }
            int indexOfName = players.getIndexOfName(command);
            int resultIndex = ladder.findResultIndex(indexOfName + 1) - 1;

            OutputView.showResult(results.getResult(resultIndex));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return print(players, results, ladder);
        }
    }

    private static void printAllResults(Players players, Results results) {
    }

}
