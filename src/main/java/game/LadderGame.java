package game;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.player.Name;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanSupplier supplier;

    public LadderGame(InputView inputView, OutputView outputView, BooleanSupplier supplier) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.supplier = supplier;
    }

    public void play() {
        Players players = this.getNames();
        LadderHeight height = this.getHeight();
        Results results = this.getResults();

        Ladder ladder = new Ladder(players, results, height);
        ladder.drawLines(supplier);

        printLadder(ladder, players, results);

        String playerName = getPlayerName();
        printLadderResult(ladder, playerName);
    }

    private Players getNames() {
        outputView.printReadNames();
        List<String> names = inputView.readTokens();
        return new Players(names);
    }

    private Results getResults() {
        outputView.printReadResults();
        List<String> results = inputView.readTokens();
        return new Results(results);
    }

    private LadderHeight getHeight() {
        outputView.printReadLadderHeight();
        int height = inputView.readLadderHeight();
        return new LadderHeight(height);
    }

    private String getPlayerName() {
        outputView.printReadNameForResult();
        return inputView.readToken();
    }

    private void printLadder(Ladder ladder, Players players, Results results) {
        outputView.printLadderCreationMessage();
        outputView.printTokens(players.getRawNames());
        outputView.printLadder(ladder.getLadderPatterns());
        outputView.printTokens(results.getRawResults());
    }

    private void printAllResults(Ladder ladder) {
        Map<Name, Result> results = ladder.getAllPlayerResults();
        results.forEach((name, result) -> outputView.printAllResults(name.rawName(), result.rawResult()));
    }

    private void printLadderResult(Ladder ladder, String playerName) {
        outputView.printResultMessage();

        if (playerName.equals("all")) {
            printAllResults(ladder);
            return;
        }

        Result result = ladder.getResultByName(playerName);
        outputView.printToken(result.rawResult());
    }
}
