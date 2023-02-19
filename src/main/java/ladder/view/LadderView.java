package ladder.view;

import ladder.dto.LadderResponse;
import ladder.dto.PlayersResponse;
import ladder.dto.ResultsResponse;

public class LadderView {
    public String readPlayerNames() {
        return InputView.readPlayerNames();
    }

    public String readResults() {
        return InputView.readResults();
    }

    public int readLadderHeight() {
        return InputView.readLadderHeight();
    }

    public void printResult(PlayersResponse playersResponse, LadderResponse ladderResponse,
                            ResultsResponse resultsResponse) {
        OutputView.printLadderResult(playersResponse, ladderResponse, resultsResponse);
    }
}
