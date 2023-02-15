package ladder.model;

import java.util.List;

public class LadderGame {


    private Ladder ladder;

    public LadderGame(List<String> playerNames) {
        validatePlayerCount(playerNames);
    }

    private void validatePlayerCount(List<String> playerNames) {
        if (playerNames.size() < 2) {
            throw new IllegalArgumentException("게임을 진행하기 위해서는 두 명 이상의 플레이어가 필요합니다.");
        }
    }
}
