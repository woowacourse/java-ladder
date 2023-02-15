package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderFactory;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.ParticipantName;
import laddergame.domain.participant.Participants;
import laddergame.domain.rung.RungNumberGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;
import laddergame.view.message.Message;

import java.util.Comparator;
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
        Participants participants = getParticipants();
        LadderFactory ladderFactory = new LadderFactory(new RungNumberGenerator());
        Ladder ladder = getLadder(participants, ladderFactory);

        OutputView.print(Message.RESULT_GUIDE.getMessage());
        List<String> participantNames = getParticipantNames(participants);

        outputView.printParticipants(participantNames);

    }

    private Participants getParticipants() {
        return inputView.getUserInput(() -> {
            OutputView.print(Message.INPUT_PARTICIPANT_NAMES_GUIDE.getMessage());
            String participantNames = inputView.readConsole();
            return new Participants(participantNames);
        });
    }

    private Ladder getLadder(final Participants participants, final LadderFactory ladderFactory) {
        return inputView.getUserInput(() -> {
            OutputView.print(Message.INPUT_LADDER_MAX_HEIGHT_GUIDE.getMessage());
            String maxLadderHeight = inputView.readConsole();
            return ladderFactory.createLadder(maxLadderHeight, participants.size());
        });
    }

    private List<String> getParticipantNames(final Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
