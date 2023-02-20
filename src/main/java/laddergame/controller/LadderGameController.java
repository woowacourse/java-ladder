package laddergame.controller;

import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.util.TrueOrFalseGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";

    private final InputView inputView;
    private final OutputView outputView;
    private final TrueOrFalseGenerator trueOrFalseGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.trueOrFalseGenerator = trueOrFalseGenerator;
    }

    public void run() {
        Players players = requestUserNames();
        Height height = requestLadderHeight();
        Ladder ladder = new Ladder(players, height, trueOrFalseGenerator);
        outputView.printResult(players.getPlayers(), ladder.getLines(), players.getMaxPlayerNameLength());
    }

    private Players requestUserNames() {
        try {
            outputView.printMessage(NAME_INPUT_REQUEST);
            return inputView.readUserNames();
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
            return requestUserNames();
        }
    }

    private Height requestLadderHeight() {
        try {
            outputView.printMessage(HEIGHT_INPUT_REQUEST);
            return inputView.readHeight();
        } catch (IllegalArgumentException e) {
            outputView.printErrormessage(e.getMessage());
            return requestLadderHeight();
        }
    }
}
