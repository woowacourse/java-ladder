package controller;

import java.util.List;
import java.util.Map;
import model.Height;
import model.Ladder;
import model.LadderGame;
import model.Line;
import model.Name;
import model.Participant;
import model.Participants;
import model.RandomBooleanGenerator;
import model.Result;
import model.Results;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final List<String> reservedNames = List.of("all");
    private final InputView inputView;
    private final OutputView outputView;

    private LadderGame ladderGame;
    private Participants participants;
    private Results results;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        participants = new Participants(inputView.inputParticipantsName());
        results = new Results(inputView.inputResults());
        Height height = new Height(inputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, new RandomBooleanGenerator(), participants.size());
        ladderGame = new LadderGame(participants, ladder, results);
        outputView.printLadderResult(participants, ladder, results);
        printResults();
    }

    private void printResults() {
        String name = inputView.inputParticipantNameForResult();
        if (reservedNames.contains(name)) {
            Map<Participant, Result> allResults = ladderGame.findAllParticipantResults();
            outputView.printParticipantResults(allResults);
            return;
        }
        Participant participant = ladderGame.findParticipant(new Name(name));
        Result result = ladderGame.findParticipantResult(participant);
        outputView.printParticipantResult(result);
        printResults();
    }
}
