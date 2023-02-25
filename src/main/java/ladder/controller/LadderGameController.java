package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Product;
import ladder.domain.Products;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final int SINGLE_RESULT_NUMBER = 1;

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Players players = repeat(() -> initializePlayers(inputView.askPlayerNames()));
        Products products = repeat(() -> initializeProducts(inputView.askResultProducts(), players.size()));
        Results results = new Results(players, products);
        int height = repeat(inputView::askLadderHeight);

        LadderGame game = new LadderGame(players, height);

        List<Line> lines = game.getUnmodifiableLines();
        outputView.showLadderGame(players, lines, products);
        game.play();
        checkResult(results);
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

    private Products initializeProducts(final List<String> names, final int playersCount) {
        validateLength(playersCount, names.size());

        List<Product> products = names.stream()
                .map(Product::new)
                .collect(Collectors.toList());

        return new Products(products);
    }

    private void validateLength(final int playerCount, final int productCount) {
        if (playerCount != productCount) {
            throw new IllegalArgumentException("참가자와 결과의 개수는 같아야합니다.\n" +
                    "playerCount : " + playerCount + " productCount : " + productCount);
        }
    }

    private void checkResult(final Results results) {
        while (true) {
            Map<Player, Product> result = repeat(() -> {
                String name = inputView.askResultByPlayerName();
                return results.toResultByPlayerName(name);
            });

            outputView.showResult(result);
            if (result.size() > SINGLE_RESULT_NUMBER) {
                return;
            }
        }
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
