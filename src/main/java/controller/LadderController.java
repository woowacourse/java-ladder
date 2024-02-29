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
        Map<Position, String> results= inputView.inputResults();//TODO: 참여자 수만큼 입력 받는다.
        Height height = new Height(inputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, new LadderRowGenerator(new RandomBooleanGenerator()), participants);
        ladderGame = new LadderGame(participants, ladder, results);
        printRandomLadder(participants, ladder);
        outputView.printResults(results);
        printResults();
    }

    private void printResults() {
        String name = inputView.inputParticipantNameForResult();
        if (!name.equals("all")) {
            String participantResult = ladderGame.findParticipantResult(new Name(name));
            outputView.printParticipantResult(participantResult);
            printResults();
            return;
        }
        Map<Name, String> allResults = ladderGame.findAllParticipantResults();
        outputView.printParticipantResult(allResults);
    }

    private void printRandomLadder(Participants participants, Ladder ladder) {
        outputView.printResultMessage();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }
}
