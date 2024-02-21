package game;

import domain.HorizontalLineStatus;
import domain.Ladder;
import generator.BooleanGenerator;
import java.util.List;
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
        // TODO: 메서드 분리
        outputView.printReadNames();
        List<String> names = inputView.readNames();

        outputView.printReadLadderHeight();
        int height = inputView.readLadderHeight();

        Ladder ladder = Ladder.of(names.size(), height);
        ladder.drawLines(booleanGenerator);

        outputView.printResultMessage();
        outputView.printNames(names);

        List<HorizontalLineStatus> statuses = ladder.createStatuses();
        outputView.printLadder(statuses);
    }
}
