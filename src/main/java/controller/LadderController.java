package controller;

import java.util.List;
import model.LadderGame;
import model.LadderGameCommand;
import strategy.PassGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final boolean DONE = false;
    private static final boolean RETRY = true;
    private static final String DEFAULT_PARTICIPANT_NAME = "";

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(PassGenerator generator, LadderGame ladderGame) {
        handle(() -> initParticipantsName(ladderGame));
        handle(() -> initLadderResult(ladderGame));
        handle(() -> initLadder(ladderGame, generator));
        handle(() -> printLadder(ladderGame));
        ladderGame.play();
        handle(() -> findLadderResult(ladderGame));
    }

    private void handle(Runnable logic) {
        boolean isRepeatable = true;

        while (isRepeatable) {
            isRepeatable = process(logic);
        }
    }

    private boolean process(Runnable logic) {
        try {
            logic.run();
            return DONE;
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return RETRY;
        }
    }

    private void initParticipantsName(LadderGame ladderGame) {
        outputView.noticeInputParticipants();

        List<String> nameInfo = inputView.inputNameOfParticipants();

        ladderGame.initParticipantsNames(nameInfo);
    }

    private void initLadderResult(LadderGame ladderGame) {
        outputView.noticeInputLadderResult();

        List<String> ladderResultInfo = inputView.inputLadderResults();

        ladderGame.initLadderResults(ladderResultInfo);
    }

    private void initLadder(LadderGame ladderGame, PassGenerator generator) {
        outputView.noticeInputHeightOfLadder();

        int heightOfLadder = inputView.inputHeightOfLadder();

        ladderGame.initLadder(generator, heightOfLadder);
    }

    private void printLadder(LadderGame ladderGame) {
        outputView.noticeLadderResult();
        outputView.printNameOfParticipants(ladderGame.getParticipantsNames());
        outputView.printLadder(ladderGame.getLadder());
        outputView.printLadderResult(ladderGame.getLadderResults());
    }

    private void findLadderResult(LadderGame ladderGame) {
        String targetParticipantName = DEFAULT_PARTICIPANT_NAME;

        while (LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND.isPlayable(targetParticipantName)) {
            outputView.noticeFindResultOfName();
            targetParticipantName = inputView.inputNameForGameResult();
            outputView.printLadderGameResult(ladderGame.findGameResult(targetParticipantName));
        }
    }
}
