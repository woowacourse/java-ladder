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

    private Players players;
    private Results results;
    private Ladder ladder;

    public LadderGameController() {
        init();
    }

    private void init() {
        this.players = setPlayers();
        this.results = setResults(players);
        LadderHeight ladderHeight = setLadderHeight();
        this.ladder = new Ladder(ladderHeight.getLadderHeight(), players.getTotalPlayers());
        this.ladder.connectBridgesRandomly(100);
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
            Results results = new ResultBuilder(InputView.inputResults()).makeResults();
            checkPlayersWithResults(players, results);
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

    private void checkPlayersWithResults(Players players, Results results) {
        if (results.matchPlayersCount(players.getTotalPlayers())) {
            throw new IllegalArgumentException("개수가 같아야됩니다(플레이어, 결과)");
        }
    }

    public void printLadderScreen() {
        OutputView.showPlayers(this.players);
        OutputView.showLadder(this.ladder);
        OutputView.showResults(this.results);
    }

    public void proceedGame() {
        String command;
        do {
            command = InputView.inputCommand();
        } while (proceedWithCommand(command));
        OutputView.showAllResult(this.players, this.results, this.ladder);
    }

    private boolean proceedWithCommand(String command) {
        try {
            if (command.equals("all")) {
                return false;
            }
            OutputView.showResult(results.getResult(ladder.findResultIndex(players.getIndexOfName(command) + 1) - 1));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
