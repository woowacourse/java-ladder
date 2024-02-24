package ladder.controller;

import ladder.model.Bars;
import ladder.model.Ladder;
import ladder.model.LadderSize;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Objects;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;
    private List<String> ladderResult;

    public void makeLadder(){
        ladderPlayers = Players.from(InputView.inputPlayerNames());

        ladderResult = InputView.inputLadderResult();

        LadderSize ladderSize = new LadderSize(InputView.inputLadderHeight(), ladderPlayers.getSize());
        ladder = Ladder.of(ladderSize);
    }

    public void showLadder() {
        OutputView.printLadderDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
        OutputView.printLadderResult(ladderResult);
    }

    public void showResult() {
        String questionedPlayer = InputView.inputQuestionedPlayer();
        if (!Objects.equals(questionedPlayer, "all")) {
            isQuestionedPlayerExist(questionedPlayer);
        }

        Bars bars = Bars.from(ladder.findBars());
        List<String> changedLadderResult = bars.calculateChangedLadderResult(ladderResult);

        OutputView.printQuestionedPlayerResultDescription();
        OutputView.printQuestionedPlayerResult(questionedPlayer, ladderPlayers.getPlayerNames(), changedLadderResult);
    }

    private void isQuestionedPlayerExist(String name) {
        if (ladderPlayers.isNotContains(name)) {
            throw new IllegalArgumentException("해당 플레이어는 존재하지 않습니다.");
        }
    }
}
