package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.PlayersDto;

public interface OutputView {
    void printErrorMessage(String message);

    void printLadderResultMessage();

    void printPlayerNames(final PlayersDto playersDto);

    void printLadder(final LadderDto ladderDto);
}
