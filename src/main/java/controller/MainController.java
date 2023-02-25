package controller;

import domain.game.LadderGame;
import domain.game.Results;
import domain.info.Info;
import domain.info.Names;
import domain.info.Rewards;
import domain.ladder.Height;
import domain.ladder.Ladder;
import utils.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final String END_COMMEND = "all";

    private final Info info;
    private final Ladder ladder;

    public MainController(final BooleanGenerator booleanGenerator) {
        info = generateInfo();
        ladder = generateLadder(booleanGenerator);
    }

    private static Info generateInfo() {
        Names names = InputView.readNames();
        Rewards rewards = InputView.readRewards();
        return new Info(names, rewards);
    }

    private Ladder generateLadder(final BooleanGenerator booleanGenerator) {
        Height height = InputView.readHeight();
        return new Ladder(info.getNames(), height, booleanGenerator);
    }

    public void start() {
        OutputView.printLadderBoard(info, ladder);
        LadderGame ladderGame = new LadderGame(info.getNames(), ladder);
        Results results = new Results(info, ladderGame);

        showResult(results);
    }

    private void showResult(Results results) {
        boolean isEnd = false;
        while (!isEnd) {
            String name = InputView.readShowName();
            OutputView.printResult(name, info.getNames(), results);
            isEnd = name.equals(END_COMMEND);
        }
    }
}
