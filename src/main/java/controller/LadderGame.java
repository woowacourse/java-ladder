package controller;

import domain.height.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.player.Players;
import domain.prize.Prizes;
import generator.BooleanGenerator;
import java.util.Optional;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private static final String GAME_OVER_COMMAND = "all";

    private final BooleanGenerator booleanGenerator;

    public LadderGame(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        Players players = repeatUntilSuccess(() -> Players.from(InputView.inputPlayerNames()));
        Prizes prizes = repeatUntilSuccess(() -> Prizes.of(InputView.inputPrizeNames(), players));
        Height height = repeatUntilSuccess(() -> new Height(InputView.inputHeight()));
        Ladder ladder = getLadder(players, prizes, height);
        LadderResult result = ladder.climb(players, prizes);
        searchPlayerResult(result);
    }

    private Ladder getLadder(Players players, Prizes prizes, Height height) {
        Ladder ladder = Ladder.create(height, players, booleanGenerator);
        OutputView.printLadder(ladder, players, prizes);
        return ladder;
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        Optional<T> result;
        do {
            result = request(supplier);
        } while (result.isEmpty());
        return result.get();
    }

    private <T> Optional<T> request(Supplier<T> supplier) {
        try {
            return Optional.of(supplier.get());
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return Optional.empty();
        }
    }

    private void searchPlayerResult(LadderResult result) {
        String name = InputView.inputPlayerNameToFindResult();
        while (!GAME_OVER_COMMAND.equals(name)) {
            OutputView.printSinglePlayerResult(result.findPrizeByName(name));
            name = InputView.inputPlayerNameToFindResult();
        }
        OutputView.printAllPlayerResult(result.getAllResults());
    }
}
