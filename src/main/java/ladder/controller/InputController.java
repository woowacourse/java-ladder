package ladder.controller;

import java.util.List;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGenerator;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.ResultCommand;
import ladder.domain.Width;
import ladder.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public ResultCommand inputResultCommand() {
        return ResultCommand.from(inputView.inputPlayerForResult());
    }

    public LadderGame initGame() {
        Players players = enroll();
        return new LadderGame(players, getPrizes(), makeLadder(players.size()));
    }

    private Players enroll() {
        List<String> names = inputView.inputPlayerNames();
        return Players.from(names);
    }

    private Prizes getPrizes() {
        List<String> names = inputView.inputPrizeNames();
        return Prizes.from(names);
    }

    private Ladder makeLadder(int playersSize) {
        Height height = new Height(inputView.inputHeight());
        Width width = new Width(getWidthSize(playersSize));
        LadderGenerator ladderGenerator = new LadderGenerator(width, height);
        return ladderGenerator.generateLadder();
    }

    private int getWidthSize(int playersSize) {
        return playersSize - 1;
    }
}
