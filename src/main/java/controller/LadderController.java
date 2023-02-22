package controller;

import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prize;
import domain.Prizes;
import domain.RandomScaffoldGenerator;
import domain.ScaffoldGenerator;
import domain.Width;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final int MINUS_VALUE_FOR_LADDER_WIDTH = 1;

    private final ScaffoldGenerator scaffoldGenerator = new RandomScaffoldGenerator();

    public void run() {
        final Names names = new Names(InputView.inputNames().stream()
                .map(Name::new)
                .collect(Collectors.toList()));
        final List<String> inputPrizes = InputView.inputPrizes();
        final Prizes prizes = new Prizes(inputPrizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList()), names);
        final int parsedHeight = InputView.inputHeight();
        final Height height = new Height(parsedHeight);
        final Width width = new Width(names.size() - MINUS_VALUE_FOR_LADDER_WIDTH);
        final Ladder ladder = new Ladder(width, height, scaffoldGenerator);
        OutputView.printResult(ladder, names, prizes);
    }
}
