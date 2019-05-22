package com.woowacourse.laddergame.domain.vo;

import com.woowacourse.laddergame.domain.Ladder;
import com.woowacourse.laddergame.domain.Players;
import com.woowacourse.laddergame.domain.Results;

public class MadeLadderVo {
    private final Players players;
    private final Ladder ladder;
    private final Results results;

    public MadeLadderVo(Players players, Ladder ladder, Results results) {
        if (ladder.getCountOfPerson() != players.size() || ladder.getCountOfPerson() != results.size()) {
            throw new IllegalArgumentException("사다리의 크기와 플레이어 수와 결과의 수가 다릅니다.");
        }

        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Results getResults() {
        return results;
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
