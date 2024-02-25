package game;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import dto.LadderRowDto;
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

        Ladder ladder = Ladder.of(players, height);
        ladder.drawLines(supplier);
        List<LadderRowDto> patterns = ladder.getLadderPatterns();

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

    private void printLadderResult(List<String> names, List<LadderRowDto> rowPatterns) {
        outputView.printResultMessage();
        outputView.printNames(names);
        outputView.printLadder(rowPatterns);
    }
}
