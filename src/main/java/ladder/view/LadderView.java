package ladder.view;

import java.util.List;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultResponse;
import ladder.dto.PlayersResponse;
import ladder.dto.PrizesResponse;

public class LadderView {
    private static final String PLAYERS_STRING_DELIMITER = ",";
    private static final String PRIZES_STRING_DELIMITER = ",";

    public String[] readPlayerNames() {
        String playerNames = InputView.readPlayerNames();
        return playerNames.split(PLAYERS_STRING_DELIMITER);
    }

    public String[] readPrizes() {
        String prizes = InputView.readPrizes();
        return prizes.split(PRIZES_STRING_DELIMITER);
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

    public void printAllPlayerResults(List<PlayerResultResponse> resultsResponses) {
        OutputView.printAllPlayerResults(resultsResponses);
    }

    public void printResult(String result) {
        OutputView.printPlayerResult(result);
    }
}
