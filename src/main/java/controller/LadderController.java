package controller;

import domain.Height;
import domain.LadderGame;
import domain.Players;
import domain.PlayersMaker;
import domain.Results;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final String DELIMITER_WITH_BLANK = "\\s*,\\s*";

    public void run() {
        Players players = makePlayers();
        Results results = makeResult(players.getNumberOfPlayers());
        Height height = new Height(inputHeight());

        LadderGame ladderGame = new LadderGame(players, results);
        ladderGame.makeLadder(height, players.getNumberOfPlayers());

        playLadderGame(ladderGame);
        getResult(players, ladderGame);
    }

    private Players makePlayers() {
        try {
            String playersName = inputPlayers();
            return PlayersMaker.makePlayers(playersName);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return makePlayers();
        }
    }

    private String inputPlayers() {
        try {
            return InputView.receivePlayer();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputPlayers();
        }
    }

    private Results makeResult(int playerCount) {
        try {
            String results = inputResults();
            return new Results(makeResults(results), playerCount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return makeResult(playerCount);
        }
    }

    private String inputResults() {
        try {
            return InputView.receiveResults();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputResults();
        }
    }

    private int inputHeight() {
        try {
            return InputView.receiveHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputHeight();
        }
    }

    private List<String> makeResults(String results) {
        return List.of(results.split(DELIMITER_WITH_BLANK));
    }

    private void playLadderGame(LadderGame ladderGame) {
        ladderGame.printLadder();
        ladderGame.playGame();
    }

    private void getResult(Players players, LadderGame ladderGame) {
        Map<String, String> ladderGameResult = ladderGame.getLadderGameResult();
        String playerNameWantToSeeResult = inputPlayerNameWantToSeeResult(players);
        OutputView.printResult(ladderGameResult, players, playerNameWantToSeeResult);
    }

    private String inputPlayerNameWantToSeeResult(Players players) {
        try {
            String playerName = InputView.receivePlayerName();
            players.validateExistPlayer(playerName);
            return playerName;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputPlayerNameWantToSeeResult(players);
        }
    }
}
