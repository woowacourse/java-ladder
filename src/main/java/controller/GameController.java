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

    public GameController(InputView inputView, OutputView outputView, ErrorHandler errorHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorHandler = errorHandler;
    }

    public void run() {

        Members members = errorHandler.readUntilNoError(() -> {
            String rawNames = requestNames();
            return makeMembers(rawNames);
        });

        Lines lines = errorHandler.readUntilNoError(() -> {
            String rawHeight = requestHeight();
            Height height = makeHeight(rawHeight);
            return makeLines(members.getCount(), height);
        });

        Game game = new Game(members, lines);
        outputView.printResult(game);
    }

    private String requestNames() {
        return inputView.readNames();
    }

    private Members makeMembers(String rawNames) {
        return new Members(rawNames);
    }

    private String requestHeight() {
        return inputView.readHeight();
    }

    private Height makeHeight(String rawHeight) {
        return new Height(rawHeight);
    }

    private Lines makeLines(int memberCount, Height height) {
        return new Lines(memberCount, height, new RandomPointStrategy());
    }
}
