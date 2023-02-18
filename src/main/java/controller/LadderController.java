package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderFactory;
import domain.Name;
import domain.Names;
import domain.RandomScaffoldGenerator;
import domain.ScaffoldGenerator;
import domain.Width;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();
    private final LadderFactory ladderFactory = new LadderFactory(scaffoldGenerator);

    public void run() {
        List<String> inputNames = InputView.inputNames();
        Names names = new Names(inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toList()));
        int parsedHeight = InputView.inputHeight();
        Ladder ladder = ladderFactory.createLadder(new Width(names.size() - 1), new Height(parsedHeight));
        OutputView.printResult(ladder, names);
    }
}
