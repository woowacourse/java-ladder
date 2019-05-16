/*
 * @(#)LadderGame.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

/**
 * 사다리 게임에 관련된 변수와 로직을 수행하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class LadderGame {
    private static final String GET_ONE_PLAYER_ERROR = "일치하는 플레이어 이름이 없습니다.";
    private static final String NEW_LINE = "\n";

    private Ladder ladder;
    private PlayerTags players;
    private ResultTags results;

    public LadderGame(PlayerTags players, ResultTags results, Floor floor) {
        this.players = players;
        this.results = results;
        ladder = new Ladder(floor, players.size());
    }

    public String getOnePlayerResult(Tag tag) {
        if (!this.players.getNames().contains(tag)) {
            throw new IllegalArgumentException(GET_ONE_PLAYER_ERROR);
        }
        int index = ladder.getPlayerResult(players.indexOf(tag));
        return results.get(index).toString();
    }

    public String getAllPlayerResult() {
        StringBuilder sb = new StringBuilder();
        for (Tag tag : players.getNames()) {
            sb.append(tag.toString() + " : " + this.getOnePlayerResult(tag) + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return players.toString() + NEW_LINE
                + ladder.toString()
                + results.toString();
    }
}
