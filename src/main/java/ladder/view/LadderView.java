package ladder.view;

import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultsResponse;
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

    public void printLadderResult(PlayersResponse playersResponse, LadderResponse ladderResponse,
                                  ResultsResponse resultsResponse) {
        OutputView.printLadderResult(playersResponse, ladderResponse, resultsResponse);
    }

    public String readPlayerName() {
        return InputView.readPlayerName();
    }

    public void printAllPlayerResults(PlayerResultsResponse resultsResponse) {
        OutputView.printAllPlayerResults(resultsResponse.getPlayerResults());
    }

    public void printResult(String result) {
        OutputView.printPlayerResult(result);
    }
}
