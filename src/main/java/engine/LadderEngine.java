package engine;

import static view.InputView.inputMaxLadderHeight;
import static view.InputView.inputNames;
import static view.InputView.inputPrizes;
import static view.InputView.inputSearchTarget;
import static view.OutputView.printLadder;
import static view.OutputView.printResults;

import java.util.ArrayList;
import java.util.List;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.LadderGame;
import domain.Participants;
import domain.Prizes;
import dto.Result;
import view.SearchTarget;

public class LadderEngine {

    public void start() {
        LadderGame ladderGame = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            Participants participants = gatherParticipants();
            Ladder ladder = Ladder.of(participants.count(), inputMaxLadderHeight());
            return makeGameWith(participants, ladder);
        });
        printLadder(ladderGame);
        repeatQueryPrizes(ladderGame);
    }

    private Participants gatherParticipants() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> Participants.of(inputNames())
        );
    }

    private LadderGame makeGameWith(Participants participants, Ladder ladder) {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> {
                    Prizes prizes = new Prizes(inputPrizes());
                    return new LadderGame(participants, ladder, prizes);
                }
        );
    }

    private void repeatQueryPrizes(LadderGame ladderGame) {
        boolean isTargetAll;
        do {
            isTargetAll = queryPrizes(ladderGame).isAll();
        } while (!isTargetAll);
    }

    private SearchTarget queryPrizes(LadderGame ladderGame) {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            SearchTarget searchTarget = inputSearchTarget();
            printResults(getResults(ladderGame, searchTarget));
            return searchTarget;
        });
    }

    private List<Result> getResults(LadderGame ladderGame, SearchTarget searchTarget) {
        if (searchTarget.isAll()) {
            return getAllResultsOf(ladderGame);
        }
        String searchTargetName = searchTarget.getName();
        Result result = new Result(searchTargetName, ladderGame.findPrizeFor(searchTargetName));
        return List.of(result);
    }

    private List<Result> getAllResultsOf(LadderGame ladderGame) {
        List<Result> results = new ArrayList<>();
        for (var name : ladderGame.getParticipantNames()) {
            Result result = new Result(name, ladderGame.findPrizeFor(name));
            results.add(result);
        }
        return results;
    }
}
