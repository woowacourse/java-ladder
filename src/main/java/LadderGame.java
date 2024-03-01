import static domain.Player.ALL;

import domain.Height;
import domain.Ladder;
import domain.Players;
import domain.Prizes;
import domain.generator.BridgeGenerator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGenerator bridgeGenerator;

    public LadderGame(InputView inputView, OutputView outputView, BridgeGenerator bridgeGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGenerator = bridgeGenerator;
    }

    public void run() {
        Players players = repeat(this::getPlayers);
        Prizes prizes = repeat(() -> getPrizes(players));
        Height height = repeat(this::getHeight);

        Ladder ladder = new Ladder(players, height, bridgeGenerator);

        outputView.printLadderGame(ladder, players.getNames(), prizes.getPrizes());
        Map<String, Integer> calculatedResults = ladder.calculate(players);

        repeat(getResultRunnable(calculatedResults, prizes));
    }

    private Height getHeight() {
        int inputHeight = inputView.readHeight();
        return new Height(inputHeight);
    }

    private Prizes getPrizes(Players players) {
        List<String> inputResults = inputView.readResults();
        return new Prizes(players, inputResults);
    }

    private Players getPlayers() {
        List<String> inputNames = inputView.readPlayerNames();
        return new Players(inputNames);
    }

    private void printResult(Map<String, Integer> calculatedResults, Prizes prizes) {
        String nameForResult = inputView.readPlayerResult();
        if (ALL.equals(nameForResult)) {
            outputView.printResult(calculatedResults, prizes);
            return;
        }
        if (!calculatedResults.containsKey(nameForResult)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        outputView.printResult(prizes.getPrizeNameOf(calculatedResults.get(nameForResult)));
        repeat(getResultRunnable(calculatedResults, prizes));
    }

    private <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(supplier);
        }
    }

    private void repeat(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            repeat(runnable);
        }
    }

    private Runnable getResultRunnable(Map<String, Integer> calculatedResults, Prizes prizes) {
        return () -> printResult(calculatedResults, prizes);
    }
}
