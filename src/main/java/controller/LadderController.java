package controller;

import common.ExecuteContext;
import domain.model.Ladder;
import domain.model.Layer;
import domain.model.PassGenerator;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final int NAMES_WIDTH_DIFFERENCE = 1;
    private final InputView inputView;
    private final OutputView outputView;
    private final PassGenerator passGenerator;

    public LadderController(InputView inputView, OutputView outputView,
        PassGenerator passGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.passGenerator = passGenerator;
    }

    public void play() {
        List<Name> names = getNames();
        Height height = getHeight();
        List<Layer> layers = makeEmptyLayers(height);
        Ladder ladder = new Ladder(height, getWidth(names.size() - NAMES_WIDTH_DIFFERENCE), layers);
        ladder.makeLineInLayers();
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

    private List<Layer> makeEmptyLayers(Height height) {
        return IntStream.range(0, height.getValue())
            .mapToObj(index -> new Layer(new ArrayList<>(), passGenerator))
            .collect(Collectors.toList());
    }

    private Width getWidth(final int size) {
        return ExecuteContext.workWithExecuteStrategy(() -> new Width(size));
    }

}
