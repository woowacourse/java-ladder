package controller;

import java.util.List;
import java.util.function.Supplier;
import model.ladder.Ladder;
import model.ladder.LadderHeight;
import model.player.Players;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    public void run() {
        Players players = retryPlayersOnException(this::preparePlayers);
        LadderHeight ladderHeight = retryLadderHeightOnException(this::prepareLadderHeight);
        Ladder ladder = Ladder.of(ladderHeight, players);
        end(players, ladder);
    }

    private Players preparePlayers() {
        List<String> playerNames = InputView.askPlayerNames();
        return Players.of(playerNames);
    }

    private LadderHeight prepareLadderHeight() {
        int ladderHeight = InputView.askLadderHeight();
        return new LadderHeight(ladderHeight);
    }

    public void end(Players players, Ladder ladder) {
        OutputView.printGameResultIntro();
        OutputView.printPlayerNames(players);
        OutputView.printLadder(ladder);
    }

    private Players retryPlayersOnException(Supplier<Players> preparePlayers) {
        try {
            return preparePlayers.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryPlayersOnException(preparePlayers);
        }
    }

    private LadderHeight retryLadderHeightOnException(Supplier<LadderHeight> prepareLadderHeight) {
        try {
            return prepareLadderHeight.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return retryLadderHeightOnException(prepareLadderHeight);
        }
    }
}
