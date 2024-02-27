package controller;

import domain.Game;
import domain.Lines;
import domain.Members;
import domain.Results;
import domain.StringParser;
import error.ErrorHandler;
import java.util.List;
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

        Results results = makeResults(members);

        Lines lines = makeLines(members);

        Game game = new Game(members, lines, results);
        outputView.printLadder(game);

        // 아래 계속 반복 (무한반복 없애기 위해 조건 걸어야할 듯)
            // 결과를 보고 싶은 사람
            // 실행 결과
    }

    private Members makeMembers() {
        return errorHandler.readUntilNoError(() -> {
            String rawNames = inputView.readNames();
            return Members.from(rawNames);
        });
    }

    private Results makeResults(Members members) {
        return errorHandler.readUntilNoError(() -> {
            String rawResults = inputView.readResults();
            List<String> results = StringParser.splitByDelimiter(rawResults, ",");
            return Results.of(results, members.getCount());
        });
    }

    private Lines makeLines(Members members) {
        return errorHandler.readUntilNoError(() -> {
            String rawHeight = inputView.readHeight();
            int height = StringParser.stringToInt(rawHeight);
            return Lines.of(members.getCount(), height, new RandomConnectionStrategy());
        });
    }
}
