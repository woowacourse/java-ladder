package controller;

import java.util.List;
import java.util.stream.Collectors;
import model.Height;
import model.Ladder;
import model.Name;
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
        Names participants = inputParticipantsName();

        generateLadder(ladderMaker, participants.getTotalParticipantSize());
        printLadder(ladderMaker, participants);
    }

    private Names inputParticipantsName() {
        outputView.noticeInputParticipants();

        List<String> inputNames = inputView.inputNameOfParticipants();
        List<Name> names = inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
        return new Names(names);
    }

    private void generateLadder(LadderMaker ladderMaker, int totalParticipantSize) {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();
        Height height = new Height(heightOfLadder);

        ladderMaker.initLadder(height, totalParticipantSize);
    }

    private void printLadder(LadderMaker ladderMaker, Names names) {
        outputView.noticeResult();

        Ladder ladder = ladderMaker.getLadder();

        outputView.printNameOfParticipants(names);
        outputView.printLadder(ladder);
    }
}
