package controller;

import domain.*;
import util.generator.RandomLineGenerator;
import view.InputView;
import view.OutputView;

import static message.ErrorMessage.INVALID_LADDER_LANGUAGE_EXCEPTION;

public class LadderController {

    public LadderController() {
    }

    public void run() {
        Players players = readPlayers();
        Results results = readResults(players.getPlayers().size());
        Ladder ladder = readLadder(players);
        OutputView.printResult(players, ladder, results);
        LadderGameResult ladderGameResult = new LadderGameResult(ladder, players, results);
        showLadderGameResult(players, ladderGameResult);
    }

    private Ladder readLadder(Players players) {
        try {
            return Ladder.from(InputView.readLadderHeight(), players.getWidth(), new RandomLineGenerator());
        } catch (NumberFormatException e) {
            System.out.println(INVALID_LADDER_LANGUAGE_EXCEPTION.getMessage());
            return readLadder(players);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLadder(players);
        }
    }

    private Results readResults(int playerCount) {
        try {
            return new Results(InputView.readResults(), playerCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readResults(playerCount);
        }
    }

    private Players readPlayers() {
        try {
            return new Players(InputView.readPlayerNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayers();
        }
    }

    private void showLadderGameResult(Players players, LadderGameResult ladderGameResult) {
        String input = InputView.readPlayer();
        if (isAll(input)) {
            OutputView.printPlayersResult(players, ladderGameResult);
            return;
        }
        Result result = ladderGameResult.get(players.findByName(input));
        OutputView.printOnePlayerResult(result);
        showLadderGameResult(players, ladderGameResult);
    }

    private boolean isAll(String input) {
        return input.equals("all");
    }
}
