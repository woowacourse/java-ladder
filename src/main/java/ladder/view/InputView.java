package ladder.view;

import ladder.dto.request.LadderHeightRequest;
import ladder.dto.request.PlayerNamesRequest;

public interface InputView {
    PlayerNamesRequest readPlayerNames();

    LadderHeightRequest readLadderHeight();
}
