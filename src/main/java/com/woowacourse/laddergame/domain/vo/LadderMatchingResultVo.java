package com.woowacourse.laddergame.domain.vo;

import com.woowacourse.laddergame.domain.Player;
import com.woowacourse.laddergame.domain.Result;

import java.util.HashMap;

public class LadderMatchingResultVo {
    private final HashMap<Player, Result> ladderMatchingResult;

    public LadderMatchingResultVo(HashMap<Player, Result> ladderMatchingResult) {
        this.ladderMatchingResult = ladderMatchingResult;
    }

    public String getResult(String playerName) {
        if (!isContains(playerName)) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다");
        }
        return ladderMatchingResult.get(new Player(playerName)).getResult();
    }

    private boolean isContains(String name) {
        return ladderMatchingResult.containsKey(new Player(name));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : ladderMatchingResult.keySet()) {
            sb.append(player.getName());
            sb.append(" : ");
            sb.append(ladderMatchingResult.get(player)).append("\n");
        }
        return sb.toString();
    }
}
