package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder_result.LadderResult;
import laddergame.domain.ladder_result.LadderResultName;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.util.BooleanGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.message.Message.LADDER_RESULT_GUIDE;
import static laddergame.view.message.Message.RESULT_GAME_GUIDE;

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
        int participantSize = participants.size();
        LadderResult ladderResult = createLadderResult(participantSize);

        Ladder ladder = createLadder(participantSize);
        printGameResult(participants, ladder, ladderResult);

        List<Integer> ladderResultPositions = ladder.startGame(participantSize);
        List<String> resultParticipantNames = getResultParticipantNames(participants);
        OutputView.print(System.lineSeparator() + RESULT_GAME_GUIDE.getMessage());
        List<String> ladderResultNames = ladderResult.getResultNamesByPosition(ladderResultPositions);
    }

    private Participants createParticipants() {
        return inputView.getInputWithRetry(() -> {
            String participantNames = inputView.getParticipantNames();
            return Participants.create(participantNames);
        });
    }

    private Ladder createLadder(final int participantSize) {
        return inputView.getInputWithRetry(() -> {
            String maxLadderHeight = inputView.getMaxLadderHeight();
            return Ladder.create(maxLadderHeight, participantSize, rungGenerator);
        });
    }

    private LadderResult createLadderResult(final int participantSize) {
        return inputView.getInputWithRetry(() -> {
            String resultNames = inputView.getLadderResultNames();
            return LadderResult.create(resultNames, participantSize);
        });
    }

    private void printGameResult(final Participants participants, final Ladder ladder, final LadderResult ladderResult) {
        OutputView.print(System.lineSeparator() + LADDER_RESULT_GUIDE.getMessage() + System.lineSeparator());
        List<String> participantNames = getParticipantNames(participants);
        List<String> ladderResultNames = getLadderResultNames(ladderResult);
        outputView.printParticipantNames(participantNames);
        outputView.printLadder(ladder.getLadderRungs(), participantNames);
        outputView.printLadderResultNames(participantNames, ladderResultNames);
    }

    private List<String> getParticipantNames(final Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getLadderResultNames(final LadderResult ladderResult) {
        return ladderResult.getResultNames()
                .stream()
                .map(LadderResultName::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String> getResultParticipantNames(final Participants participants) {
        return inputView.getInputWithRetry(() -> {
            String resultParticipantName = inputView.getResultParticipantName();
            return participants.getResultParticipantNames(resultParticipantName);
        });
    }
}
