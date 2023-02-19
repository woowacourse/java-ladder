package controller;

import domain.model.Ladder;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final int NAMES_WIDTH_DIFFERENCE = 1;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<Name> names = inputView.inputNames()
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
        Ladder ladder = Ladder.makeLadder(new Height(inputView.inputLadderHeight()),
            new Width(names.size() - NAMES_WIDTH_DIFFERENCE));
        outputView.printResult(names, ladder);
    }
}
