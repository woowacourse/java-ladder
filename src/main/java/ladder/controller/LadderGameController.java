package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Players players = initializePlayers(inputView.askPlayerNames());
        int height = inputView.askLadderHeight();
        LadderGame game = new LadderGame(players, height);

        List<String> playerResult = game.toUnmodifiablePlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());

        outputView.showGameResult(playerResult, game.toUnmodifiableLines());
    }

    private Players initializePlayers(final List<String> names) {
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
    }
}
