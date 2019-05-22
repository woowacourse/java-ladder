package laddergame;

import laddergame.domain.gameresult.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Player;
import laddergame.domain.player.PlayerBuilder;
import laddergame.domain.player.Players;
import laddergame.domain.result.ResultBuilder;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameMain {
    private static final String COMMAND_ALL = "all";

    public static void main(String[] args) {
        Players players = setPlayers();
        Results results = setResults(players);
        Ladder ladder = new Ladder(setLadderHeight().getLadderHeight(), players.getPlayersSize());
        ladder.connectBridgesRandomly();
        OutputView.showPlayers(players);
        OutputView.showLadder(ladder);
        OutputView.showResults(results);
        GameResult gameResult = new GameResult(ladder.getResultOfPlayer(players, results));
        String command;
        do {
            command = setCommand(players);
            OutputView.showResult(gameResult.getResultWithPlayer(command));
        } while (!command.equals(COMMAND_ALL));
        OutputView.showAllResult(gameResult);
    }

    private static Players setPlayers() {
        try {
            return PlayerBuilder.buildPlayers(InputView.inputPlayers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setPlayers();
        }
    }

    private static Results setResults(Players players) {
        try {
            Results results = ResultBuilder.buildResults(InputView.inputResults());
            checkCountOfResultsWithPlayers(players, results);
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

    private static void checkCountOfResultsWithPlayers(Players players, Results results) {
        if (!results.isSameSizeWith(players)) {
            throw new IllegalArgumentException("개수가 같아야됩니다(플레이어, 결과)");
        }
    }

    private static String checkCommand(Players players ,String command){
        if (!command.equals(COMMAND_ALL) && !players.contains(command)) {
            throw new IllegalArgumentException("존재하지않는 이름입니다.");
        }
        return command;
    }

    private static String setCommand(Players players) {
        try {
            String command = InputView.inputCommand();
            return checkCommand(players, command);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return setCommand(players);
        }
    }
}
