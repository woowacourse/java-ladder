package ladder.view;

import java.util.List;
import ladder.dto.LadderResponse;
import ladder.dto.PlayersResponse;

public class LadderView {
    public String readPlayerNames() {
        return InputView.readPlayerNames();
    }

    public int readLadderHeight() {
        return InputView.readLadderHeight();
    }

    public void printResult(PlayersResponse playersResponse, LadderResponse ladderResponse) {
        OutputView.printResult(playersResponse, ladderResponse);
    }
}
