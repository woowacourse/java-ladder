package ladder;

import java.util.function.Supplier;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.linegenerator.RandomBooleanSupplier;
import ladder.domain.ladder.linegenerator.StickListGenerator;
import ladder.domain.ladder.linegenerator.SticksPatternGenerator;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.product.Product;
import ladder.domain.product.Products;
import ladder.dto.LadderDto;
import ladder.dto.LadderGameResultDto;
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

        ResultRequest resultRequest;
        do {
            resultRequest = repeatUntilNoException(() -> requestResult(result));
        } while (resultRequest.isContinueProgram());
    }

    private static LadderGameResult runLadderGame() {
        Players players = inputPlayers();
        Products products = inputProducts(players);
        Height height = inputHeight();

        StickListGenerator stickListGenerator = new SticksPatternGenerator(new RandomBooleanSupplier());
        Ladder ladder = Ladder.of(height, players.size(), stickListGenerator);
        LadderGame ladderGame = new LadderGame(ladder, players, products);

        OUTPUT_VIEW.printResult(LadderDto.from(ladder), PlayersDto.from(players), ProductsDto.from(products));
        return ladderGame.progress();
    }

    private static ResultRequest requestResult(LadderGameResult result) {
        ResultRequest resultRequest = INPUT_VIEW.inputResultRequest();

        if (resultRequest.isRequestAll()) {
            printAllResult(result);
        }
        if (resultRequest.isSingleRequest()) {
            printSingleResult(result, resultRequest.getPlayerName());
        }
        return resultRequest;
    }

    private static void printAllResult(LadderGameResult result) {
        OUTPUT_VIEW.printTotalResult(LadderGameResultDto.from(result));
    }

    private static void printSingleResult(LadderGameResult result, String playerName) {
        Product productResult = result.findResult(new Player(playerName));
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
}
