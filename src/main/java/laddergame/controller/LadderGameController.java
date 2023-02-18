package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderFactory;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.rung.RungNumberGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.message.Message.RESULT_GUIDE;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = createParticipants();
        LadderFactory ladderFactory = createLadderFactory();
        Ladder ladder = createLadder(participants, ladderFactory);
        printGameResult(participants, ladder);
    }

    private Participants createParticipants() {
        return inputView.getInputWithRetry(() -> {
            String participantNames = inputView.getParticipantNames();
            return Participants.create(participantNames);
        });
    }

    private LadderFactory createLadderFactory() {
        RungNumberGenerator rungNumberGenerator = new RungNumberGenerator();
        return LadderFactory.create(rungNumberGenerator);
    }

    private Ladder createLadder(final Participants participants, final LadderFactory ladderFactory) {
        return inputView.getInputWithRetry(() -> {
            String maxLadderHeight = inputView.getMaxLadderHeight();
            return ladderFactory.createLadder(maxLadderHeight, participants.size());
        });
    }

    private void printGameResult(final Participants participants, final Ladder ladder) {
        OutputView.print(RESULT_GUIDE.getMessage());
        List<String> participantNames = getParticipantNames(participants);
        outputView.printParticipantNames(participantNames);
        outputView.printLadder(ladder.getLadderRungs(), participantNames);
    }

    private List<String> getParticipantNames(final Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
