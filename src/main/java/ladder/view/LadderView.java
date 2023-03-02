package ladder.view;

import java.util.List;
import ladder.dto.LadderResponse;
import ladder.dto.PlayerResultResponse;

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

    public void printLadderResult(LadderResponse ladderResponse) {
        OutputView.printLadderResult(ladderResponse);
    }

    public String readPlayerName() {
        return InputView.readPlayerName();
    }

    public void printAllPlayerResults(List<PlayerResultResponse> resultsResponses) {
        OutputView.printAllPlayerResults(resultsResponses);
    }

    public void printPlayerResult(PlayerResultResponse result) {
        OutputView.printPlayerResult(result);
    }
}
