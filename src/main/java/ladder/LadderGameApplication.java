package ladder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.linegenerator.RandomBooleanSupplier;
import ladder.domain.linegenerator.StickListGenerator;
import ladder.domain.linegenerator.SticksPatternGenerator;
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
        Players players = inputPlayers();
        Products products = inputProducts();
        Height height = inputHeight();

        StickListGenerator stickListGenerator = new SticksPatternGenerator(new RandomBooleanSupplier());
        Ladder ladder = Ladder.of(height, players.size(), stickListGenerator);

        LadderGame ladderGame = new LadderGame(ladder, players, products);
        LadderGameResult result = ladderGame.progress();
        OUTPUT_VIEW.printResult(toDto(ladder), toDto(players), toDto(products));

        while (true) {
            ResultRequest resultRequest = INPUT_VIEW.inputResultRequest();
            if (resultRequest.isRequestAll()) {
                OUTPUT_VIEW.printTotalResult(toDto(result));
                continue;
            }
            Product productResult = result.findResult(new Player(resultRequest.getPlayerName()));
            OUTPUT_VIEW.printSingleResult(productResult.getName());
        }
    }

    private static Players inputPlayers() {
        return Players.from(INPUT_VIEW.inputPlayerNames());
    }

    private static Products inputProducts() {
        return Products.from(INPUT_VIEW.inputProductNames());
    }

    private static Height inputHeight() {
        return new Height(INPUT_VIEW.inputHeight());
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
