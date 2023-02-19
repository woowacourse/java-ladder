package controller;

import common.ExecuteContext;
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
        List<Name> names = getNames();
        Ladder ladder = Ladder.makeLadder(getHeight(),
            getWidth(names.size() - NAMES_WIDTH_DIFFERENCE));
        outputView.printResult(names, ladder);
    }

    private List<Name> getNames() {
        return ExecuteContext.workWithExecuteStrategy(() -> inputView.inputNames()
            .stream()
            .map(Name::new)
            .collect(Collectors.toList()));
    }

    private Height getHeight() {
        return ExecuteContext.workWithExecuteStrategy(
            () -> new Height(inputView.inputLadderHeight()));
    }

    private Width getWidth(int size) {
        return ExecuteContext.workWithExecuteStrategy(() -> new Width(size));
    }

}
