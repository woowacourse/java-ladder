package controller;

import domain.Game;
import domain.GameResult;
import domain.Ladder;
import domain.Members;
import domain.Result;
import domain.Results;
import domain.StringParser;
import domain.ResultTarget;
import error.ErrorHandler;
import java.util.List;
import java.util.Map;
import strategy.RandomConnectionStrategy;
import view.InputView;
import view.OutputView;

public class GameController {

    public static final int MAX_GAME_COUNT = 50;

    private final InputView inputView;
    private final OutputView outputView;
    private final ErrorHandler errorHandler;

    public GameController(InputView inputView, OutputView outputView, ErrorHandler errorHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorHandler = errorHandler;
    }

    public void run() {

        Members members = errorHandler.readUntilNoError(this::makeMembers);

        Results results = errorHandler.readUntilNoError(() -> makeResults(members));

        Ladder ladder = errorHandler.readUntilNoError(() -> makeLadder(members));

        Game game = new Game(members, ladder, results);
        outputView.printLadder(game);

        GameResult gameResult = game.matchResult();

        manageResult(members, gameResult);
    }

    private Members makeMembers() {
        String rawNames = inputView.readNames();
        List<String> names = StringParser.splitByDelimiter(rawNames, ",");
        return Members.from(names);
    }

    private Results makeResults(Members members) {
        String rawResults = inputView.readResults();
        List<String> results = StringParser.splitByDelimiter(rawResults, ",");
        return Results.of(results, members.getCount());
    }

    private Ladder makeLadder(Members members) {
        String rawHeight = inputView.readHeight();
        int height = StringParser.stringToInt(rawHeight);
        return Ladder.of(height, members.getCount(), new RandomConnectionStrategy());
    }

    private ResultTarget makeResultTarget(Members members) {
        String rawTargetName = inputView.readTarget();
        return ResultTarget.of(rawTargetName, members.getMembers());
    }

    private void manageResult(Members members, GameResult gameResult) {
        ResultTarget resultTarget = showResult(members, gameResult);
        int count = MAX_GAME_COUNT;
        while (count-- > 0 && !resultTarget.isAllMembers()) {
            resultTarget = showResult(members, gameResult);
        }
    }

    private ResultTarget showResult(Members members, GameResult gameResult) {
        ResultTarget resultTarget = errorHandler.readUntilNoError(() -> makeResultTarget(members));
        Map<String, Result> result = gameResult.getResultByTarget(resultTarget);
        outputView.printResult(result);
        return resultTarget;
    }
}
