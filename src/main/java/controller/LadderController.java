package controller;

import java.util.Map;
import model.Height;
import model.Ladder;
import model.LadderGame;
import model.LadderRowGenerator;
import model.Name;
import model.Participants;
import model.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Participants participants = new Participants(inputView.inputParticipantsName());
        Map<Integer, String> results = inputView.inputResults();//TODO: 참여자 수만큼 입력 받는다.
        Height height = new Height(inputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, new LadderRowGenerator(new RandomBooleanGenerator()), participants);
        LadderGame ladderGame = new LadderGame(participants, ladder, results);
        printRandomLadder(participants, ladder);

        extracted(results, ladderGame);
    }

    private void extracted(Map<Integer, String> results, LadderGame ladderGame) {
        outputView.printResults(results);
        String name = inputView.inputParticipantNameForResult();
        String participantResult = ladderGame.findParticipantResult(new Name(name));
        outputView.printParticipantResult(participantResult);
        Map<Name, String> allResults = ladderGame.findAllParticipantResults();
        outputView.printParticipantResult(allResults);
    }

    private void printRandomLadder(Participants participants, Ladder ladder) {
        outputView.printResultMessage();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }
}
