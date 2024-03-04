package ladder.controller;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.PlayerName;
import ladder.domain.Price;
import ladder.domain.linegenerator.LineGenerator;
import ladder.domain.linegenerator.RandomBooleanSupplier;
import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerNamesDto;
import ladder.dto.PriceDto;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        List<PlayerName> playerNames = inputPlayerNames();
        List<Price> prices = inputPriceNames();
        Height height = inputHeight();
        LineGenerator lineGenerator = new LineGenerator(new RandomBooleanSupplier());
        Ladder ladder = Ladder.makeLadder(height, playerNames.size(), lineGenerator);
        LadderGame ladderGame = new LadderGame(playerNames, ladder);

        printLadder(playerNames, ladder, prices);
        printResult(ladderGame.playGame(), prices);
    }

    private List<PlayerName> inputPlayerNames() {
        try {
            return inputView.inputPlayerNames().stream()
                    .map(PlayerName::new)
                    .toList();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputPlayerNames();
        }
    }

    private List<Price> inputPriceNames() {
        try {
            return inputView.inputPriceNames().stream()
                    .map(Price::new)
                    .toList();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputPriceNames();
        }
    }

    private Height inputHeight() {
        try {
            return new Height(inputView.inputHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputHeight();
        }
    }

    private void printLadder(List<PlayerName> playerNames, Ladder ladder, List<Price> prices) {
        PlayerNamesDto playerNamesDto = toDto(playerNames);
        LadderDto ladderDto = toDto(ladder);
        PriceDto priceDto = toPriceDto(prices);
        outputView.printResult(ladderDto, playerNamesDto, priceDto);
    }

    private PlayerNamesDto toDto(List<PlayerName> playerNames) {
        List<String> resultPlayerNames = playerNames.stream()
                .map(PlayerName::getName)
                .toList();
        return new PlayerNamesDto(resultPlayerNames);
    }

    private PriceDto toPriceDto(List<Price> prices) {
        List<String> resultPriceNames = prices.stream()
                .map(Price::getPrice)
                .toList();
        return new PriceDto(resultPriceNames);
    }

    private LadderDto toDto(Ladder ladder) {
        List<LineDto> lineDtos = IntStream.range(0, ladder.getHeight())
                .mapToObj(height -> toLineDto(ladder, height))
                .toList();
        return new LadderDto(lineDtos);
    }

    private LineDto toLineDto(Ladder ladder, int height) {
        List<Boolean> sticks = IntStream.range(0, ladder.getWidth())
                .mapToObj(width -> ladder.isExist(height, width))
                .toList();
        return new LineDto(sticks);
    }

    private void printResult(List<String> result, List<Price> prices) {
        String selectName = inputView.inputSelectName();
        if (result.contains(selectName)) {
            int index = result.indexOf(selectName);
            outputView.printOneReward(selectName, prices.get(index));
            printResult(result, prices);
            return;
        }
        if (selectName.equals("all")) {
            outputView.printReward(result, prices);
            return;
        }
        printResult(result, prices);
    }
}
