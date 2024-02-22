package controller;

import domain.Game;
import domain.Height;
import domain.Lines;
import domain.Members;
import strategy.PointStrategy;
import strategy.RandomPointStrategy;
import view.InputView;
import view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PointStrategy pointStrategy;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pointStrategy = new RandomPointStrategy();
    }

    public void run() {
        String rawNames = inputView.readNames();
        Members members = new Members(rawNames);

        String rawHeight = inputView.readHeight();
        Height height = new Height(rawHeight);
        Lines lines = new Lines(members.getCount(), height, pointStrategy);

        Game game = new Game(members, lines);

        outputView.printResult(game);
    }
}
