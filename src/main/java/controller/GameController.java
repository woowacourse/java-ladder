package controller;

import domain.Game;
import domain.GameResult;
import domain.Ladder;
import domain.Member;
import domain.Members;
import domain.Result;
import domain.Results;
import domain.StringParser;
import error.ErrorHandler;
import java.util.List;
import java.util.Map;
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

        Ladder ladder = makeLines(members);

        Game game = new Game(members, ladder, results);
        outputView.printLadder(game);

        GameResult gameResult = game.matchResult();

        int count = 50;
        while (count-- > 0) {
            String targetName = makeTargetName(members);
            if (targetName.equals("all")) {
                Map<Member, Result> result = gameResult.getResultOfAllMember();
                outputView.printResult(result);
                break;
            }
            Result result = gameResult.getResultByMemberName(targetName);
            outputView.printResult(result);
        }
    }

    private Members makeMembers() {
        return errorHandler.readUntilNoError(() -> {
            String rawNames = inputView.readNames();
            List<String> names = StringParser.splitByDelimiter(rawNames, ",");
            return Members.from(names);
        });
    }

    private Results makeResults(Members members) {
        return errorHandler.readUntilNoError(() -> {
            String rawResults = inputView.readResults();
            List<String> results = StringParser.splitByDelimiter(rawResults, ",");
            return Results.of(results, members.getCount());
        });
    }

    private Ladder makeLines(Members members) {
        return errorHandler.readUntilNoError(() -> {
            String rawHeight = inputView.readHeight();
            int height = StringParser.stringToInt(rawHeight);
            return Ladder.of(height, members.getCount(), new RandomConnectionStrategy());
        });
    }

    private String makeTargetName(Members members) {
        return errorHandler.readUntilNoError(() -> {
            String rawTargetName = inputView.readTarget();
            return members.checkMemberExistByName(rawTargetName);
        });
    }
}
