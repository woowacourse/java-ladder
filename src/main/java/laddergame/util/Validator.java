package laddergame.util;

import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Rewards;

import java.util.HashMap;
import java.util.List;

public class Validator {
    private static final String INPUT_NULL_ERROR_MESSAGE = "입력에는 공백이 들어올 수 없습니다";
    private static final String WRONG_LADDER_ERROR_MESSAGE = "잘못된 사다리가 만들어졌습니다.";
    private static final String REWARD_COUNT_ERROR_MESSAGE = "reward 개수는 플레이어의 수와 같아야 합니다.";
    private static final String WRONG_HEIGHT_ERROR_MESSAGE = "양의 정수만 입력해주세요.";

    public void checkNull(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_ERROR_MESSAGE);
        }
    }

    public void validateLadder(Ladder ladder, int height) {
        if (height == 1) {
            return;
        }
        List<Line> lines = ladder.getLines();
        HashMap<Integer, Integer> falseIndexCountmap = new HashMap<>();
        for (Line line : lines) {
            falseIndexCountmap = line.checkFalseIndex(falseIndexCountmap);
        }
        if (falseIndexCountmap.containsValue(height)) {
            throw new LadderStateException(WRONG_LADDER_ERROR_MESSAGE);
        }
    }

    public void validateRewards(Rewards rewards, int playerCount) {
        if (rewards.getRewards().size() != playerCount) {
            throw new IllegalArgumentException(REWARD_COUNT_ERROR_MESSAGE);
        }

    }

    public int validateHeight(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_HEIGHT_ERROR_MESSAGE);
        }
    }
}
