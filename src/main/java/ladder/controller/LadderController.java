package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Objects;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;
    private LadderResult ladderResult;

    public void makeLadder(){
        ladderPlayers = Players.from(InputView.inputPlayerNames());

        ladderResult = new LadderResult(InputView.inputLadderResult());
        ladderResult.isSameLengthWithLadderPlayers(ladderPlayers.getSize());

        LadderSize ladderSize = new LadderSize(InputView.inputLadderHeight(), ladderPlayers.getSize());
        ladder = Ladder.of(ladderSize);
    }

    public void showLadder() {
        OutputView.printLadderDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
        OutputView.printLadderResult(ladderResult.getLadderResult());
    }

    public void showResult() {
        String questionedPlayer = InputView.inputQuestionedPlayer();
        if (!Objects.equals(questionedPlayer, "all")) {
            isQuestionedPlayerExist(questionedPlayer);
        }

        Bars bars = Bars.from(ladder.findBars());
        LadderResult changedLadderResult = ladderResult.moveThroughLadder(bars.getBars());

        OutputView.printQuestionedPlayerResultDescription();
        OutputView.printQuestionedPlayerResult(questionedPlayer, ladderPlayers.getPlayerNames(),
                changedLadderResult.getLadderResult());
    }

    private void isQuestionedPlayerExist(String name) {
        if (ladderPlayers.isNotContains(name)) {
            throw new IllegalArgumentException("해당 플레이어는 존재하지 않습니다.");
        }
    }
}
