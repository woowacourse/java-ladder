package controller;

import java.util.Map;
import model.Height;
import model.Ladder;
import model.LadderGame;
import model.LadderRowGenerator;
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
        Height height = new Height(inputView.inputLadderHeight());
        Map<Integer, String> results = inputView.inputResults();//TODO: 참여자 수만큼 입력 받는다.
        Ladder ladder = new Ladder(height, new LadderRowGenerator(new RandomBooleanGenerator()), participants);
        LadderGame ladderGame = new LadderGame(participants, ladder, results);

        outputView.printResult();
        outputView.printParticipantsName(participants);
        outputView.printLadder(ladder);
    }
}
