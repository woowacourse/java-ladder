package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Players players = repeat(() -> initializePlayers(inputView.askPlayerNames()));
        Results results = repeat(() -> new Results(players, inputView.askResultProducts()));
        int height = repeat(inputView::askLadderHeight);
        LadderGame game = new LadderGame(players, height);

        showLadder(game, results);
        game.play();

        checkResult(results);
    }

    private void checkResult(final Results results) {
        while (true) {
            Map<String, String> result = repeat(() -> {
                String name = inputView.askResultByPlayerName();
                return results.toResultByPlayerName(name);
            });
            outputView.showResult(result);
            if (result.size() > 1) {
                return;
            }
        }
    }

    private void showLadder(final LadderGame game, final Results results) {
        List<String> playerResult = game.toUnmodifiablePlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());

        outputView.showLadderGame(playerResult, game.toUnmodifiableLines(), results.toUnmodifiableResults());
    }

    private Players initializePlayers(final List<String> names) {
        int index = 0;
        List<Player> players = new ArrayList<>();

        for (String name : names) {
            Player player = new Player(name, index++);
            players.add(player);
        }

        return new Players(players);
    }

    public <T> T repeat(Supplier<T> input) {
        try {
            return input.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(input);
        }
    }
}
