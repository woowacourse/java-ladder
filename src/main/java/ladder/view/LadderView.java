package ladder.view;

import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultsResponse;
import ladder.dto.PlayersResponse;
import ladder.dto.PrizesResponse;

public class LadderView {
    public String readPlayerNames() {
        return InputView.readPlayerNames();
    }

    public String readPrizes() {
        return InputView.readPrizes();
    }

    public int readLadderHeight() {
        return InputView.readLadderHeight();
    }

    public void printLadderResult(PlayersResponse playersResponse, LadderResponse ladderResponse,
                                  PrizesResponse prizesResponse) {
        OutputView.printLadderResult(playersResponse, ladderResponse, prizesResponse);
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
