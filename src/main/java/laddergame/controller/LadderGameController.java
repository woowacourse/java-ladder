package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.PlayerBuilder;
import laddergame.domain.player.Players;
import laddergame.domain.result.ResultBuilder;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private static final String COMMAND_ALL = "all";
    private static final int CONNECTING_BRIDGE_TRIAL_COUNT = 100;

    private Players players;
    private Results results;
    private Ladder ladder;

    public LadderGameController() {
        init();
    }

    public void playGame() {
        String command;
        do {
            command = InputView.inputCommand();
            printResult(command);
        } while (!command.equals(COMMAND_ALL));
        OutputView.showAllResult(this.players, this.results, this.ladder);
    }

    private void init() {
        this.players = setPlayers();
        this.results = setResults(players);
        LadderHeight ladderHeight = setLadderHeight();
        this.ladder = new Ladder(ladderHeight.getLadderHeight(), players.getPlayersSize());
        this.ladder.connectBridgesRandomly(CONNECTING_BRIDGE_TRIAL_COUNT);
    }

    private Players setPlayers() {
        try {
            return new PlayerBuilder(InputView.inputPlayers()).buildPlayers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setPlayers();
        }
    }

    private Results setResults(Players players) {
        try {
            Results results = new ResultBuilder(InputView.inputResults()).buildResults();
            checkCountOfResultsWithPlayers(players, results);
            return results;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setResults(players);
        }
    }

    private LadderHeight setLadderHeight() {
        try {
            return new LadderHeight(InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLadderHeight();
        }
    }

    private void checkCountOfResultsWithPlayers(Players players, Results results) {
        if (results.isSameSizeWith(players)) {
            throw new IllegalArgumentException("개수가 같아야됩니다(플레이어, 결과)");
        }
    }

    private void printResult(String command){
        try {
            OutputView.showResult(results.getResult(ladder.findIndexOfResult(players.getIndexOfName(command))));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printLadder() {
        OutputView.showPlayers(this.players);
        OutputView.showLadder(this.ladder);
        OutputView.showResults(this.results);
    }
}
