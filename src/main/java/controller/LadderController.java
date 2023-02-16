package controller;

import static java.util.stream.Collectors.*;

import domain.Ladder;
import domain.LadderHeight;
import domain.Name;
import domain.Names;
import java.util.List;
import java.util.function.Supplier;
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
        Names names = repeat(this::createNames);
        LadderHeight ladderHeight = repeat(this::createLadderHeight);
        Ladder ladder = Ladder.create(names.getSize(),ladderHeight,  numberGenerator);
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

    private <T> T repeat(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeat(inputSupplier);
        }
    }
}
