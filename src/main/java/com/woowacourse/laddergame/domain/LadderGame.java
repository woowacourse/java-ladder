package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.domain.vo.LadderMatchingResultVo;
import com.woowacourse.laddergame.domain.vo.MadeLadderVo;
import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LadderGame {
    private final MadeLadderVo madeLadderVo;

    public LadderGame(MadeLadderVo madeLadderVo) {
        this.madeLadderVo = madeLadderVo;
    }

    public LadderMatchingResultVo run() {
        HashMap<Player, Result> gameResults = new LinkedHashMap<>();
        for (int playerNo = 1; playerNo <= madeLadderVo.getPlayers().size(); playerNo++) {
            gameResults.put(getPlayer(playerNo), getResult(takeLadder(playerNo)));
        }
        return new LadderMatchingResultVo(gameResults);
    }

    private Player getPlayer(int playerNo) {
        return madeLadderVo.getPlayers().get(new NaturalNumber(playerNo));
    }

    private Result getResult(int resultNo) {
        return madeLadderVo.getResults().get(new NaturalNumber(resultNo));
    }

    private int takeLadder(int playerNo) {
        return madeLadderVo.getLadder().takeLadder(new NaturalNumber(playerNo));
    }
}
