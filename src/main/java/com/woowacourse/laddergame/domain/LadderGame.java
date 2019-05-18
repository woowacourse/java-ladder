package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.domain.vo.LadderGameResultVo;
import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LadderGame {
    private Players players;
    private Ladder ladder;
    private Results results;

    public LadderGame(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public LadderGameResultVo run() {
        HashMap<String, String> gameResults = new LinkedHashMap<>();
        for (int playerNo = 1; playerNo <= players.size(); playerNo++) {
            String playerName = players.get(new NaturalNumber(playerNo)).getName();
            int resultNo = ladder.takeLadder(new NaturalNumber(playerNo));
            String result = results.get(new NaturalNumber(resultNo)).getResult();
            gameResults.put(playerName, result);
        }
        return new LadderGameResultVo(gameResults);
    }
}
