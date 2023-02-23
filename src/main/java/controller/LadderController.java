package controller;

import model.GameResult;
import java.util.List;
import java.util.stream.Collectors;
import model.Height;
import model.Ladder;
import model.LadderGame;
import model.LadderGameCommand;
import model.LadderResult;
import model.LadderResults;
import model.Names;
import strategy.PassGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final String DEFAULT_PARTICIPANT_NAME = "";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(PassGenerator generator) {
        try {
            Names participants = inputParticipantsName();
            LadderResults ladderResults = inputLadderResults(participants.getTotalParticipantSize());
            Ladder ladder = generateLadder(generator, participants.getTotalParticipantSize());
            printLadder(ladder, participants, ladderResults);
            LadderGame ladderGame = LadderGame.of(participants, ladder, ladderResults);
            printLadderGame(ladderGame);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
        }
    }

    private Names inputParticipantsName() {
        outputView.noticeInputParticipants();

        List<String> inputNames = inputView.inputNameOfParticipants();
        return Names.of(inputNames);
    }

    private LadderResults inputLadderResults(int totalParticipantSize) {
        outputView.noticeInputLadderResult();

        List<String> results = inputView.inputLadderResults();
        List<LadderResult> ladderResults = results.stream()
                .map(LadderResult::new)
                .collect(Collectors.toUnmodifiableList());
        return LadderResults.of(ladderResults, totalParticipantSize);
    }

    private Ladder generateLadder(PassGenerator generator, int totalParticipantSize) {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();
        Height height = new Height(heightOfLadder);

        return Ladder.of(generator, height, totalParticipantSize);
    }

    private void printLadder(Ladder ladder, Names names, LadderResults ladderResults) {
        outputView.noticeLadderResult();
        outputView.printNameOfParticipants(names);
        outputView.printLadder(ladder);
        outputView.printLadderResult(ladderResults);
    }

    private void printLadderGame(LadderGame ladderGame) {
        String targetParticipantName = DEFAULT_PARTICIPANT_NAME;

        while (LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND.isPlayable(targetParticipantName)) {
            outputView.noticeFindResultOfName();
            targetParticipantName = inputView.inputNameForGameResult();
            List<GameResult> gameResults = ladderGame.findGameResult(targetParticipantName);
            outputView.printLadderGameResult(gameResults);
        }
    }
}
