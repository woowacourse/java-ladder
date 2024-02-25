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

        Members members = makeMembers();

        Lines lines = makeLines(members);

        Game game = new Game(members, lines);
        outputView.printResult(game);
    }

    private Members makeMembers() {
        return errorHandler.readUntilNoError(() -> {
            String rawNames = inputView.readNames();
            return new Members(rawNames);
        });
    }

    private Lines makeLines(Members members) {
        return errorHandler.readUntilNoError(() -> {
            String rawHeight = inputView.readHeight();
            int height = StringParser.stringToInt(rawHeight);
            return new Lines(members.getCount(), height, new RandomConnectionStrategy());
        });
    }
}
