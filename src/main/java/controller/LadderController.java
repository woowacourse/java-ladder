package controller;

import java.util.List;
import java.util.stream.Collectors;
import model.Height;
import model.Ladder;
import model.LadderResult;
import model.LadderResults;
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
        LadderResults ladderResults = inputLadderResults(participants.getTotalParticipantSize());
        generateLadder(ladderMaker, participants.getTotalParticipantSize());
        printLadder(ladderMaker, participants, ladderResults);
    }

    private Names inputParticipantsName() {
        outputView.noticeInputParticipants();

        List<String> inputNames = inputView.inputNameOfParticipants();
        List<Name> names = inputNames.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
        return new Names(names);
    }

    private LadderResults inputLadderResults(int totalParticipantSize) {
        outputView.noticeInputLadderResult();

        List<String> results = inputView.inputLadderResults();
        List<LadderResult> ladderResults = results.stream()
                .map(LadderResult::new)
                .collect(Collectors.toUnmodifiableList());
        return LadderResults.of(ladderResults, totalParticipantSize);
    }

    private void generateLadder(LadderMaker ladderMaker, int totalParticipantSize) {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();
        Height height = new Height(heightOfLadder);

        ladderMaker.initLadder(height, totalParticipantSize);
    }

    private void printLadder(LadderMaker ladderMaker, Names names, LadderResults ladderResults) {
        outputView.noticeResult();

        Ladder ladder = ladderMaker.getLadder();

        outputView.printNameOfParticipants(names);
        outputView.printLadder(ladder);
        outputView.printLadderResult(ladderResults);
    }
}
