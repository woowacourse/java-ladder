package controller;

import static java.util.stream.Collectors.*;

import domain.Ladder;
import domain.LadderHeight;
import domain.Name;
import domain.Names;
import java.util.List;
import utils.NumberGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LadderController(InputView inputView,
                            OutputView outputView,
                            NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Names names = createNames();
        LadderHeight ladderHeight = createLadderHeight();
        Ladder ladder = Ladder.create(ladderHeight, names.getSize(), numberGenerator);
        outputView.printResult(names, ladder);
    }

    private Names createNames() {
        List<String> rawNames = inputView.sendNames();
        return rawNames.stream()
                .map(Name::new)
                .collect(collectingAndThen(toList(), Names::new));
    }

    private LadderHeight createLadderHeight() {
        int height = inputView.sendLadderHeight();
        return new LadderHeight(height);
    }
}
