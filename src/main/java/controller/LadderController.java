package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

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
        Ladder ladder = Ladder.create(names.size(), ladderHeight, numberGenerator);

        outputView.printResult(names, ladder);
    }

    private Names createNames() {
        try {
            List<String> rawNames = inputView.sendNames();
            return rawNames.stream()
                    .map(Name::new)
                    .collect(collectingAndThen(toList(), Names::new));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createNames();
        }
    }

    private LadderHeight createLadderHeight() {
        try {
            int height = inputView.sendLadderHeight();
            return new LadderHeight(height);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return createLadderHeight();
        }
    }
}
