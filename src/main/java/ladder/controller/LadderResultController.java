package ladder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import ladder.domain.GamePrizes;
import ladder.domain.LadderResult;
import ladder.domain.Name;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderResultController {

    private static final String KEEP_CHECK = "Y";
    private static final String STOP_CHECK = "N";

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderResult ladderResult;
    private final Participants participants;
    private final GamePrizes gamePrizes;

    public LadderResultController(InputView inputView, OutputView outputView, LadderResult ladderResult,
                                  Participants participants, GamePrizes gamePrizes) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderResult = ladderResult;
        this.participants = participants;
        this.gamePrizes = gamePrizes;
    }

    public void checkResult() {
        boolean endOrNotChoice = repeatUntilValid(this::isEndOrNot);

        if (endOrNotChoice) {
            checkParticipant();
        }
    }

    private void checkParticipant() {
        String participantChoice = inputView.getSeeResultParticipant();
        if (Objects.equals(participantChoice, "all")) {
            outputView.printAllResult(participants.getNames(), findAllPrizes());
            checkResult();
            return;
        }

        try {
            Name name = new Name(participantChoice);
            outputView.printSingleResult(findPrize(name));
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
        checkResult();
    }

    private List<String> findAllPrizes() {
        List<String> prizes = new ArrayList<>();

        for (Name name : participants.getNames()) {
            prizes.add(findPrize(name));
        }
        return prizes;
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
