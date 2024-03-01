package controller;

import java.util.Map;
import model.Height;
import model.Ladder;
import model.LadderGame;
import model.LadderRowGenerator;
import model.Name;
import model.Participants;
import model.Position;
import model.RandomBooleanGenerator;
import model.Result;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    private LadderGame ladderGame;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Participants participants = new Participants(inputView.inputParticipantsName());
        Map<Position, Result> results = inputView.inputResults();
        Height height = new Height(inputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, new LadderRowGenerator(new RandomBooleanGenerator()), participants.size());
        ladderGame = new LadderGame(participants, ladder, results);
        outputView.printRandomLadderResult(participants, ladder, results);
        printResults();
    }

    private void printResults() {
        String name = inputView.inputParticipantNameForResult();
        if (!name.equals("all")) {
            Result participantResult = ladderGame.findParticipantResult(new Name(name));
            outputView.printParticipantResult(participantResult);
            printResults();
            return;
        }
        Map<Name, Result> allResults = ladderGame.findAllParticipantResults();
        outputView.printParticipantResult(allResults);
    }
}
