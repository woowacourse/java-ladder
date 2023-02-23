package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.Names;
import domain.Result;
import domain.Rewards;
import utils.BooleanGenerator;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final String END_COMMEND = "all";

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
    }

    public void start() {
        Names names = inputView.readNames();
        Rewards rewards = inputView.readRewards(names);
        Height height = inputView.readHeight();

        Ladder ladder = new Ladder(names, height, booleanGenerator);
        outputView.printLadderBoard(names, ladder, rewards);
        LadderGame ladderGame = new LadderGame(names.getNamesSize(), ladder.getFloors());
        Result result = new Result(names.getNames(), ladderGame.getResult(), rewards.getRewards());

        showResult(result, names);
    }

    private void showResult(Result result, Names names) {
        boolean isEnd = false;
        while (!isEnd) {
            String name = inputView.readShowName();
            outputView.printResult(name, names, result);
            isEnd = name.equals(END_COMMEND);
        }
    }
}
