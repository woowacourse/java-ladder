package controller;

import domain.Game;
import domain.Lines;
import domain.Members;
import domain.StringParser;
import error.ErrorHandler;
import strategy.RandomConnectionStrategy;
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
            int height = StringParser.stringToInt(rawHeight);
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

    private Lines makeLines(int memberCount, int height) {
        return new Lines(memberCount, height, new RandomConnectionStrategy());
    }
}
