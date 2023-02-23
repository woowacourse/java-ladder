package laddergame.util;

import laddergame.domain.Ladder;
import laddergame.domain.Line;

import java.util.HashMap;
import java.util.List;

public class Validator {
    public void checkNull(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("입력에는 공백이 들어올 수 없습니다");
        }
    }

    public void validateLadder(Ladder ladder, int height) {
        List<Line> lines = ladder.getLines();
        if (height != 1) {
            HashMap<Integer, Integer> falseIndexCountmap = new HashMap<>();
            for (Line line : lines) {
                falseIndexCountmap = line.checkFalseIndex(falseIndexCountmap);
            }
            if (falseIndexCountmap.containsValue(height)) {
                throw new LadderStateException("잘못된 사다리가 만들어졌습니다.");
            }
        }
    }

    public void validateRewards(List<String> rewardNames, int playerCount) {
        if (rewardNames.stream().filter(rewardName -> rewardName.isBlank()).count() != 0) {
            throw new IllegalArgumentException("reward 목록에 공백이 입력될 수 없습니다.");
        }
        if (rewardNames.size() != playerCount) {
            throw new IllegalArgumentException("reward 개수는 플레이어의 수와 같아야 합니다.");
        }

    }

    public int validateHeight(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수만 입력해주세요.");
        }
    }
}
