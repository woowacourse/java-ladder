package game;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderRowPattern;
import domain.player.Players;
import java.util.List;
import java.util.function.BooleanSupplier;
import util.LoopFunction;
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
        Players players = LoopFunction.retryOnException(this::getNames);
        LadderHeight height = LoopFunction.retryOnException(this::getHeight);

        Ladder ladder = Ladder.of(players, height);
        ladder.drawLines(supplier);
        List<LadderRowPattern> patterns = ladder.getLadderPatterns();

        printLadderResult(players.getNames(), patterns);
    }

    private Players getNames() {
        outputView.printReadNames();
        List<String> names = inputView.readNames();
        return new Players(names);
    }

    private LadderHeight getHeight() {
        outputView.printReadLadderHeight();
        int height = inputView.readLadderHeight();
        return new LadderHeight(height);
    }

    private void printLadderResult(List<String> names, List<LadderRowPattern> rowPatterns) {
        outputView.printResultMessage();
        outputView.printNames(names);
        outputView.printLadder(rowPatterns);
    }
}
