package controller;

import domain.model.Ladder;
import domain.vo.Height;
import domain.vo.LineCount;
import domain.vo.Name;
import domain.service.LadderMaker;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        List<Name> names = inputView.inputNames().stream()
                .map(Name::new)
                .collect(Collectors.toList());
        int height = inputView.inputLadderHeight();
        Ladder ladder = ladderMaker.make(new Height(height), new LineCount(names.size() - 1));
        outputView.printResult(names, ladder);
    }
}
