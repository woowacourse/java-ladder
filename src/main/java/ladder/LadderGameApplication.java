package ladder;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.ladder.linegenerator.RandomBooleanSupplier;
import ladder.domain.ladder.linegenerator.StickListGenerator;
import ladder.domain.ladder.linegenerator.SticksPatternGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.product.Product;
import ladder.domain.product.Products;
import ladder.dto.LadderDto;
import ladder.dto.LadderGameResultDto;
import ladder.dto.LineDto;
import ladder.dto.PlayersDto;
import ladder.dto.ProductsDto;
import ladder.dto.ResultRequest;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApplication {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        LadderGameResult result = runLadderGame();
        while (true) {
            repeatUntilNoException(() -> requestResult(result));
        }
    }

    private static LadderGameResult runLadderGame() {
        Players players = inputPlayers();
        Products products = inputProducts(players);
        Height height = inputHeight();

        StickListGenerator stickListGenerator = new SticksPatternGenerator(new RandomBooleanSupplier());
        Ladder ladder = Ladder.of(height, players.size(), stickListGenerator);
        LadderGame ladderGame = new LadderGame(ladder, players, products);

        OUTPUT_VIEW.printResult(toDto(ladder), toDto(players), toDto(products));
        return ladderGame.progress();
    }

    private static void requestResult(LadderGameResult result) {
        ResultRequest resultRequest = INPUT_VIEW.inputResultRequest();
        if (resultRequest.isRequestAll()) {
            OUTPUT_VIEW.printTotalResult(toDto(result));
            return;
        }
        Product productResult = result.findResult(new Player(resultRequest.getPlayerName()));
        OUTPUT_VIEW.printSingleResult(productResult.getName());
    }

    private static Players inputPlayers() {
        return repeatUntilNoException(
                () -> Players.from(INPUT_VIEW.inputPlayerNames())
        );
    }

    private static Products inputProducts(Players players) {
        Supplier<Products> productsSupplier = () -> {
            Products products = Products.from(INPUT_VIEW.inputProductNames());
            LadderGame.validate(players, products);
            return products;
        };

        return repeatUntilNoException(productsSupplier);
    }

    private static Height inputHeight() {
        return repeatUntilNoException(
                () -> new Height(INPUT_VIEW.inputHeight())
        );
    }

    private static <T> T repeatUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printErrorMessage(exception);
            return repeatUntilNoException(supplier);
        }
    }

    private static void repeatUntilNoException(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException exception) {
            OUTPUT_VIEW.printErrorMessage(exception);
            repeatUntilNoException(runnable);
        }
    }

    private static PlayersDto toDto(Players players) {
        return new PlayersDto(players.getNames());
    }

    private static ProductsDto toDto(Products products) {
        return new ProductsDto(products.getNames());
    }

    private static LadderDto toDto(Ladder ladder) {
        List<LineDto> lineDtos = IntStream.range(0, ladder.getHeight())
                .mapToObj(height -> toLineDto(ladder, height))
                .toList();
        return new LadderDto(lineDtos);
    }

    private static LineDto toLineDto(Ladder ladder, int height) {
        List<Boolean> sticks = IntStream.range(0, ladder.getWidth())
                .mapToObj(width -> ladder.isExist(height, width))
                .toList();
        return new LineDto(sticks);
    }

    private static LadderGameResultDto toDto(LadderGameResult result) {
        Map<String, String> playerToProduct = result.getResults().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        entry -> entry.getValue().getName()
                ));
        return new LadderGameResultDto(playerToProduct);
    }
}
