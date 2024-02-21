package ladder.dto.request;

import ladder.domain.ladder.LadderHeight;
import ladder.util.InputUtils;

public record LadderHeightRequest(String input) {
    public LadderHeight toHeight() {
        int height = InputUtils.parseToInt(input);

        return new LadderHeight(height);
    }
}
