package com.woowacourse.laddergame.domain.vo;

import java.util.HashMap;

public class LadderGameResultVo {
    private HashMap<String, String> ladderGameResult;

    public LadderGameResultVo(HashMap<String, String> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public String getResult(String playerName) {
        if (!isContains(playerName)) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다");
        }
        return ladderGameResult.get(playerName);
    }

    boolean isContains(String name) {
        return ladderGameResult.containsKey(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : ladderGameResult.keySet()) {
            sb.append(name);
            sb.append(" : ");
            sb.append(ladderGameResult.get(name)).append("\n");
        }
        return sb.toString();
    }
}
