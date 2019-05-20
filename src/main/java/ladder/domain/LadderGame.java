/*
 * @(#)LadderGame.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.Position;
import ladder.domain.tag.Tag;

/**
 * 사다리 게임에 관련된 변수와 로직을 수행하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class LadderGame {
    private Ladder ladder;
    private PlayerTags players;
    private ResultTags results;

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerTags getPlayers() {
        return players;
    }

    public ResultTags getResults() {
        return results;
    }

    public LadderGame(PlayerTags players, ResultTags results, LadderHeight ladderHeight) {
        this.players = players;
        this.results = results;
        this.ladder = new Ladder(ladderHeight, new LadderWidth(players.size()));
    }

    public GameResult getAllResult() {
        GameResult gameResult = new GameResult();
        for (Tag tag : players) {
            Position result = ladder.moveToResult(players.indexOf(tag));
            gameResult.put(tag, results.get(result.getPosition()));
        }
        return gameResult;
    }
}
