package com.woowacourse.laddergame.domain.vo;

import com.woowacourse.laddergame.domain.Ladder;
import com.woowacourse.laddergame.domain.Players;
import com.woowacourse.laddergame.domain.Results;

public class MadeLadderVO {
    private final Players players;
    private final Ladder ladder;
    private final Results results;

    public MadeLadderVO(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(players.toString()).append("\n");
        sb.append(ladder.toString());
        sb.append(results.toString());

        return sb.toString();
    }
}
