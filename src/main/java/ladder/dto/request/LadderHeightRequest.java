package ladder.dto.request;

import ladder.domain.ladder.Height;
import ladder.util.InputUtils;

public record LadderHeightRequest(String input) {
    public Height toHeight() {
        int height = InputUtils.parseToInt(input);

        return new Height(height);
    }
}
