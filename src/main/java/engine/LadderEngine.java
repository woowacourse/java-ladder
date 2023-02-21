package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.Line;
import domain.Participant;
import domain.Participants;
import generator.LineGenerator;
import generator.RandomBridgeGenerator;
import view.SearchTarget;

public class LadderEngine {

    public void start() {
        Ladder ladder = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
            Participants participants = gatherParticipants();
            List<String> prizes = InputView.inputPrizes();
            int height = InputView.inputMaxLadderHeight();
            List<Line> lines = makeLines(participants.count(), height);
            return new Ladder(participants, lines, prizes);
        });

        OutputView.printLadder(ladder);
        queryPrizes(ladder);
    }

    private Participants gatherParticipants() {
        return IllegalArgumentExceptionHandler.handleExceptionByRepeating(
                () -> createParticipantsWith(InputView.inputNames())
        );
    }

    private List<Line> makeLines(final int participantsCount, final int height) {
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new RandomBridgeGenerator());
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generate(participantsCount);
            lines.add(line);
        }
        return lines;
    }

    private void queryPrizes(Ladder ladder) {
        boolean isSearchTargetAll;
        do {
            isSearchTargetAll = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
                SearchTarget searchTarget = inputSearchTarget();
                printResults(getResults(ladder, searchTarget));
                return searchTarget.isAll();
            });
        } while (!isSearchTargetAll);
    }

    private Participants createParticipantsWith(final List<String> names) {
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }

    private Map<String, String> getResults(Ladder ladder, SearchTarget searchTarget) {
        if (searchTarget.isAll()) {
            return getAllResultsOf(ladder);
        }
        String searchTargetName = searchTarget.getName();
        return Map.of(searchTargetName, ladder.findPrizeFor(searchTargetName));
    }

    private Map<String, String> getAllResultsOf(Ladder ladder) {
        Map<String, String> prizes = new HashMap<>();
        for (String name : ladder.getParticipantNames()) {
            prizes.put(name, ladder.findPrizeFor(name));
        }
        return prizes;
    }
}
