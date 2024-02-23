package controller;

import domain.Game;
import domain.Height;
import domain.Lines;
import domain.Members;
import error.ErrorHandler;
import strategy.RandomPointStrategy;
import view.InputView;
import view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorHandler errorHandler;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorHandler = new ErrorHandler();
    }

    public void run() {
        Members members = errorHandler.readUntilNoError(this::makeMembers);
        Lines lines = errorHandler.readUntilNoError(() -> makeLines(members));
        Game game = Game.of(members, lines);
        outputView.printResult(game);
    }

    private Members makeMembers() {
        String rawNames = inputView.readNames();
        return Members.from(rawNames);
    }

    private Lines makeLines(Members members) {
        String rawHeight = inputView.readHeight();
        Height height = Height.from(rawHeight);
        return Lines.of(members.getCount(), height, new RandomPointStrategy());
    }
}
