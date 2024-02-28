package controller;

import model.ladder.Height;
import model.ladder.Ladder;
import model.ladder.LadderGame;
import model.ladder.LadderGenerateStrategy;
import model.participant.Participant;
import model.participant.Participants;
import model.result.Results;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() throws IOException {
        Participants participants = new Participants(inputView.inputParticipantsName());
        Results results = new Results(inputView.inputResults());
        Ladder ladder = new Ladder(new LadderGenerateStrategy(), new Height(inputView.inputLadderHeight()), participants);
        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        outputView.printLadderResult(ladderGame);
        play(ladderGame);
    }

    private void play(LadderGame ladderGame) throws IOException {
        String participantName = inputView.inputParticipantName();
        while (!participantName.equals(Participants.ENTIRE)) {
            outputView.printParticipantResult(ladderGame.matchResult(new Participant(participantName)));
            participantName = inputView.inputParticipantName();
        }
        outputView.printAllParticipantsResult(ladderGame.matchAllResults());
    }
}
