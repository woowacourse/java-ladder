package controller;

import domain.game.LadderGame;
import domain.game.Results;
import domain.info.Names;
import domain.info.Rewards;
import domain.ladder.Height;
import domain.ladder.Ladder;
import utils.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final String END_COMMEND = "all";

    private final Names names;
    private final Rewards rewards;
    private final Ladder ladder;

    public MainController(final BooleanGenerator booleanGenerator) {
        names = InputView.readNames();
        rewards = InputView.readRewards();
        ladder = generateLadder(booleanGenerator);
    }

    public void start() {
        OutputView.printLadderBoard(names, ladder, rewards);
        LadderGame ladderGame = new LadderGame(names, ladder);
        Results results = new Results(names, ladderGame, rewards);

        showResult(results);
    }

    private Ladder generateLadder(final BooleanGenerator booleanGenerator) {
        Height height = InputView.readHeight();
        return new Ladder(names, height, booleanGenerator);
    }

    private void showResult(Results results) {
        boolean isEnd = false;
        while (!isEnd) {
            String name = InputView.readShowName();
            OutputView.printResult(name, names, results);
            isEnd = name.equals(END_COMMEND);
        }
    }
}
