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

    public void play() throws IOException {
        Participants participants = new Participants(inputView.inputParticipantsName());
        Results results = new Results(inputView.inputResult());
        Height height = new Height(inputView.inputLadderHeight());
        Ladder ladder = new Ladder(new LadderGenerateStrategy(), height, participants);
        LadderGame ladderGame = new LadderGame(ladder, participants, results);
        outputView.printResult(ladderGame);
        String name = inputView.inputParticipantName();
        while(!name.equals("all")){
            outputView.printOneResult(ladderGame.matchResult(new Participant(name)));
            name = inputView.inputParticipantName();
        }
        outputView.printAllResult(ladderGame.matchAllResults());
    }
}
