package controller;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.game.LadderGame;
import domain.info.Names;
import domain.game.Results;
import domain.info.Rewards;
import utils.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final String END_COMMEND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(BooleanGenerator booleanGenerator) {
        Names names = inputView.readNames();
        Rewards rewards = inputView.readRewards(names);
        Ladder ladder = generateLadder(names, booleanGenerator);

        outputView.printLadderBoard(names, ladder, rewards);
        LadderGame ladderGame = new LadderGame(names, ladder);
        Results results = new Results(names, ladderGame, rewards);

        showResult(results, names);
    }

    private Ladder generateLadder(Names names, BooleanGenerator booleanGenerator) {
        Height height = inputView.readHeight();
        return new Ladder(names, height, booleanGenerator);
    }

    private void showResult(Results results, Names names) {
        boolean isEnd = false;
        while (!isEnd) {
            String name = inputView.readShowName();
            outputView.printResult(name, names, results);
            isEnd = name.equals(END_COMMEND);
        }
    }
}
