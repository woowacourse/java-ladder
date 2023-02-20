package controller;

import java.util.List;
import model.Height;
import model.Ladder;
import model.Names;
import model.LadderMaker;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(LadderMaker ladderMaker) {
        inputParticipantsName(ladderMaker);
        generateLadder(ladderMaker);
        printLadder(ladderMaker);
    }

    private void inputParticipantsName(LadderMaker ladderMaker) {
        outputView.noticeInputParticipants();

        List<String> inputNames = inputView.inputNameOfParticipants();
        ladderMaker.initParticipants(inputNames);
    }

    private void generateLadder(LadderMaker ladderMaker) {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();
        Height height = new Height(heightOfLadder);
        Names participantsName = ladderMaker.getParticipantsName();

        ladderMaker.initLadder(height, participantsName.getTotalParticipantSize());
    }

    private void printLadder(LadderMaker ladderMaker) {
        outputView.noticeResult();

        Ladder ladder = ladderMaker.getLadder();

        outputView.printNameOfParticipants(ladderMaker.getParticipantsName());
        outputView.printLadder(ladder);
    }
}
