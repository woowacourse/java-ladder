package game;

import domain.HorizontalLineStatus;
import domain.Ladder;
import generator.BooleanGenerator;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGame(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void play() {
        // TODO: 올바른 예외 처리를 위해 names/height 래핑
        List<String> names = retryOnException(this::getNames);
        int height = retryOnException(this::getHeight);

        Ladder ladder = Ladder.of(names.size(), height);
        ladder.drawLines(booleanGenerator);
        List<HorizontalLineStatus> statuses = ladder.createStatuses();

        printLadderResult(names, statuses);
    }

    private List<String> getNames() {
        outputView.printReadNames();
        return inputView.readNames();
    }

    private int getHeight() {
        outputView.printReadLadderHeight();
        return inputView.readLadderHeight();
    }

    private void printLadderResult(List<String> names, List<HorizontalLineStatus> statuses) {
        outputView.printResultMessage();
        outputView.printNames(names);
        outputView.printLadder(statuses);
    }

    private <T> T retryOnException(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retryOnException(function);
        }
    }
}
