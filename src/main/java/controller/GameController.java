package controller;

import domain.Game;
import domain.GameResult;
import domain.Lines;
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

        Lines lines = makeLines(members);

        Game game = new Game(members, lines, results);
        outputView.printLadder(game);

        GameResult gameResult = game.matchResult(); // TODO 결과 이상

        int count = 10; // TODO: dummy
        while (count-- > 0) {
            String rawTargetName = makeTargetName(members);
            if (rawTargetName.equals("all")) {
                Map<Member, Result> result = gameResult.getResultOfAllMember();
                outputView.printResult(result);
                break;
            }
            Result result = gameResult.getResultByMemberName(rawTargetName);
            outputView.printResult(result);
        }
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

    private String makeTargetName(Members members) { // TODO: refactoring
        return errorHandler.readUntilNoError(() -> {
            String rawTargetName = inputView.readTarget();
            boolean isExist = members.checkMemberExist(rawTargetName);
            if (!isExist) {
                return "all";
            }
            return rawTargetName;
        });
    }
}
