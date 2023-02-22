package controller;

import dto.GameResult;
import java.util.List;
import java.util.stream.Collectors;
import model.Height;
import model.Ladder;
import model.LadderGame;
import model.LadderGameCommand;
import model.LadderResult;
import model.LadderResults;
import model.Name;
import model.Names;
import model.LadderMaker;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final String DEFAULT_PARTICIPANT_NAME = "";
    private static final String FIND_TOTAL_RESULT_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(LadderMaker ladderMaker) {
        try {
            Names participants = inputParticipantsName();
            LadderResults ladderResults = inputLadderResults(participants.getTotalParticipantSize());
            initLadder(ladderMaker, participants.getTotalParticipantSize());
            printLadder(ladderMaker, participants, ladderResults);
            LadderGame ladderGame = LadderGame.of(participants, ladderMaker.findLadder(), ladderResults);
            printLadderGame(ladderGame);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
        }
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

    private void initLadder(LadderMaker ladderMaker, int totalParticipantSize) {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();
        Height height = new Height(heightOfLadder);

        ladderMaker.initLadder(height, totalParticipantSize);
    }

    private void printLadder(LadderMaker ladderMaker, Names names, LadderResults ladderResults) {
        outputView.noticeLadderResult();

        Ladder ladder = ladderMaker.findLadder();

        outputView.printNameOfParticipants(names);
        outputView.printLadder(ladder);
        outputView.printLadderResult(ladderResults);
    }

    private void printLadderGame(LadderGame ladderGame) {
        String targetParticipantName = DEFAULT_PARTICIPANT_NAME;

        while (LadderGameCommand.DEFAULT_COMMAND.isPlayable(targetParticipantName)) {
            outputView.noticeFindResultOfName();
            targetParticipantName = inputView.inputNameForGameResult();
            List<GameResult> gameResults = ladderGame.findGameResult(targetParticipantName);
            outputView.printLadderGameResult(gameResults);
        }
    }
}
