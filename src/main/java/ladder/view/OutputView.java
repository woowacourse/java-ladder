package ladder.view;

import ladder.dto.response.LadderResponse;
import ladder.dto.response.PlayersResponse;

public interface OutputView {
    void printErrorMessage(String message);

    void printLadderResultMessage();

    void printPlayerNames(PlayersResponse playersResponse);

    void printLadder(LadderResponse ladderResponse);
}
