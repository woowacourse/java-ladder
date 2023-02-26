package domain.game;

import domain.info.Info;
import domain.info.Name;
import domain.info.Reward;
import domain.ladder.Floor;
import domain.ladder.Ladder;

public class LadderGame {
    private static final int MOVE_FORWARD = 1;
    private static final int MOVE_BACKWARD = -1;
    private static final int MOVE_STRAIGHT = 0;

    private final Info info;
    private final Ladder ladder;

    public LadderGame(final Info info, final Ladder ladder) {
        this.info = info;
        this.ladder = ladder;
    }

    public Results play() {
        Results results = new Results();

        for (int i = 0; i < info.getNamesSize(); i++) {
            Name player = info.getName(i);
            Reward reward = calculateReward(i);
            results.putResult(player, reward);
        }

        return results;
    }

    private Reward calculateReward(int index) {
        for (Floor floor : ladder.getFloors()) {
            index += calculateWeight(index, floor);
        }
        return info.getReward(index);
    }

    private static int calculateWeight(final int index, final Floor floor) {
        if (isAbleForward(index, floor)) {
            return MOVE_FORWARD;
        }
        if (isAbleBackward(index, floor)) {
            return MOVE_BACKWARD;
        }
        return MOVE_STRAIGHT;
    }

    private static boolean isAbleForward(final int index, final Floor floor) {
        return index < floor.getPointsSize() && floor.getPoint(index);
    }

    private static boolean isAbleBackward(final int index, final Floor floor) {
        return index > 0 && floor.getPoint(index - 1);
    }
}
