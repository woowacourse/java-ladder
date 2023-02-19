package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderResult;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.util.BooleanGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.message.Message.RESULT_GUIDE;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator rungGenerator;

    public LadderGameController(final InputView inputView, final OutputView outputView, final BooleanGenerator rungGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.rungGenerator = rungGenerator;
    }

    public void start() {
        Participants participants = createParticipants();
        LadderResult ladderResult = createLadderResult(participants);
        Ladder ladder = createLadder(participants);
        printGameResult(participants, ladder);
    }

    private Participants createParticipants() {
        return inputView.getInputWithRetry(() -> {
            String participantNames = inputView.getParticipantNames();
            return Participants.create(participantNames);
        });
    }

    private Ladder createLadder(final Participants participants) {
        return inputView.getInputWithRetry(() -> {
            String maxLadderHeight = inputView.getMaxLadderHeight();
            return Ladder.create(maxLadderHeight, participants.size(), rungGenerator);
        });
    }

    private LadderResult createLadderResult(final Participants participants) {
        return inputView.getInputWithRetry(() -> {
            String resultNames = inputView.getLadderResultNames();
            return LadderResult.create(resultNames, participants.size());
        });
    }

    private void printGameResult(final Participants participants, final Ladder ladder) {
        OutputView.print(System.lineSeparator() + RESULT_GUIDE.getMessage() + System.lineSeparator());
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
