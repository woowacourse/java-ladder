package ladder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.ladderGame.LadderResult;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
import ladder.domain.prize.GamePrizes;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderResultController {

    private static final String KEEP_CHECK = "Y";
    private static final String STOP_CHECK = "N";
    private static final String SEE_ALL_PARTICIPANT_COMMEND = "all";

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderResult ladderResult;
    private final Participants participants;
    private final GamePrizes gamePrizes;

    public LadderResultController(InputView inputView, OutputView outputView, MadeLadderDto ladderResult,
                                  Participants participants, GamePrizes gamePrizes) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderResult = new LadderResult(ladderResult, participants.size());
        this.participants = participants;
        this.gamePrizes = gamePrizes;
    }

    public void showResult() {
        boolean endOrNotChoice = repeatUntilValid(this::isEndOrNot);

        if (endOrNotChoice) {
            chooseParticipant();
            showResult();
        }
    }

    private void chooseParticipant() {
        String participantChoice = inputView.getSeeResultParticipant();

        if (SEE_ALL_PARTICIPANT_COMMEND.equals(participantChoice)) {
            outputView.printAllResult(participants.getNames(), findAllPrizes());
            return;
        }

        try {
            Name name = new Name(participantChoice);
            outputView.printSingleResult(findPrize(name));
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
    }

    private List<String> findAllPrizes() {
        List<String> foundPrize = new ArrayList<>();

        for (Name name : participants.getNames()) {
            foundPrize.add(findPrize(name));
        }
        return foundPrize;
    }

    private String findPrize(Name name) {
        int position = participants.findNamePosition(name);
        int prizePosition = ladderResult.getEndPosition(position);
        return gamePrizes.findPrize(prizePosition);
    }

    private boolean isEndOrNot() {
        String inputChoice = inputView.getEndOrNotChoice();

        if (inputChoice.equals(KEEP_CHECK)) {
            return true;
        }
        if (inputChoice.equals(STOP_CHECK)) {
            return false;
        }
        throw new IllegalArgumentException(KEEP_CHECK + " 혹은 " + STOP_CHECK + " 중 하나를 입력해야 합니다.");
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return repeatUntilValid(function);
        }
    }
}
