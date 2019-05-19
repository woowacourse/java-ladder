package ladder;

import ladder.domain.*;
import ladder.view.InputView;

public class CreateController {
    public static Players createPlayers() {
        try {
            return new Players(InputView.readName());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createPlayers();
        }
    }

    public static LadderRewards createRewards(int width) {
        try {
            return new LadderRewards(InputView.readReward(), width);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createRewards(width);
        }
    }

    public static Height createHeight() {
        try {
            return new Height(InputView.readHeight());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return createHeight();
        }
    }
}
