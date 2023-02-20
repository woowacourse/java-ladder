package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.exception.handler.IllegalArgumentExceptionHandler;
import domain.Ladder;
import domain.Line;
import domain.Participant;
import domain.Participants;
import dto.Result;
import generator.LineGenerator;
import generator.RandomBridgeGenerator;
import view.InputView;
import view.OutputView;

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
        do {
            List<Result> results = IllegalArgumentExceptionHandler.handleExceptionByRepeating(() -> {
                String participantName = InputView.inputParticipantNameToFind();
                List<String> participantNames;
                if (participantName.equals("all")) {
                    participantNames = ladder.getParticipants().getNames();
                } else {
                    participantNames = List.of(participantName);
                }

                List<Result> results2 = new ArrayList<>();
                for (String name : participantNames) {
                    String prize = ladder.findPrizeFor(name);
                    results2.add(new Result(name, prize));
                }
                return results2;
            });
            OutputView.printResults(results);
            if (results.size() > 1) {
                break;
            }
        } while (true);
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

    private Participants createParticipantsWith(final List<String> names) {
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }
}
