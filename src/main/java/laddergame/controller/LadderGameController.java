package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.rung.RungBooleanGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = createParticipants();
        Ladder ladder = createLadder(participants);
        printGameResult(participants, ladder);
    }

    private Participants createParticipants() {
        return inputView.repeatUntilGettingValidValue(() -> {
            String participantNames = inputView.readParticipantNames();
            return Participants.create(participantNames);
        });
    }

    private Ladder createLadder(final Participants participants) {
        RungBooleanGenerator rungNumberGenerator = new RungBooleanGenerator();
        return inputView.repeatUntilGettingValidValue(() -> {
            String maxLadderHeight = inputView.readMaxLadderHeight();
            return Ladder.create(rungNumberGenerator, maxLadderHeight, participants.size());
        });
    }

    private void printGameResult(final Participants participants, final Ladder ladder) {
        outputView.printResultGuide();
        List<String> participantNames = getParticipantNames(participants);
        outputView.printParticipantNames(participantNames);
        outputView.printLadder(ladder.getLadder(), participantNames);
    }

    private List<String> getParticipantNames(final Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
