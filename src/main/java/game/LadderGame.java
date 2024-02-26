package game;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.result.Results;
import dto.RowPatternDto;
import domain.player.Players;
import java.util.List;
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
        List<RowPatternDto> patterns = ladder.getLadderPatterns();

        printLadderResult(players.getNames(), patterns);
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

    private void printLadderResult(List<String> names, List<RowPatternDto> rowPatterns) {
        outputView.printResultMessage();
        outputView.printNames(names);
        outputView.printLadder(rowPatterns);
    }
}
