package engine;

import static view.InputView.inputMaxLadderHeight;
import static view.InputView.inputNames;
import static view.InputView.inputPrizes;
import static view.InputView.inputSearchTarget;
import static view.OutputView.printLadder;
import static view.OutputView.printResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import domain.Participant;
import domain.Participants;
import domain.Prizes;
import generator.LineGenerator;
import generator.RandomBridgeGenerator;
import view.SearchTarget;

public class LadderEngine {

    public void start() {
        LadderGame ladderGame = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            Participants participants = gatherParticipants();
            Ladder ladder = makeLadder(participants.count(), inputMaxLadderHeight());
            return makeGameWith(participants, ladder);
        });
        printLadder(ladderGame);
        repeatQueryPrizes(ladderGame);
    }

    private Participants gatherParticipants() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> createParticipantsWith(inputNames())
        );
    }

    private Ladder makeLadder(final int participantsCount, final int height) {
        LineGenerator lineGenerator = new LineGenerator(new RandomBridgeGenerator());
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generate(participantsCount);
            lines.add(line);
        }
        return new Ladder(lines);
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

    private Map<String, String> getResults(LadderGame ladderGame, SearchTarget searchTarget) {
        if (searchTarget.isAll()) {
            return getAllResultsOf(ladderGame);
        }
        String searchTargetName = searchTarget.getName();
        return Map.of(searchTargetName, ladderGame.findPrizeFor(searchTargetName));
    }

    private Map<String, String> getAllResultsOf(LadderGame ladderGame) {
        Map<String, String> prizes = new HashMap<>();
        for (String name : ladderGame.getParticipantNames()) {
            prizes.put(name, ladderGame.findPrizeFor(name));
        }
        return prizes;
    }

    private Participants createParticipantsWith(final List<String> names) {
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }
}
