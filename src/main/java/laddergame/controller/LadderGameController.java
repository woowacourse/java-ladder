package laddergame.controller;

import java.util.List;
import laddergame.model.LadderHeight;
import laddergame.model.Line;
import laddergame.model.Participants;
import laddergame.model.RandomLinesGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = inputView.readParticipantNames();
        LadderHeight ladderHeight = inputView.readLadderHeight();
        RandomLinesGenerator randomGenerator = new RandomLinesGenerator();
        List<Line> lines = randomGenerator.getLines(ladderHeight, participants);

        printResult(participants, lines);
    }

    private void printResult(Participants participants, List<Line> lines) {
        outputView.printResultHeader();
        outputView.printParticipantsNames(participants);
        outputView.printLadder(lines);
    }
}
