/*
 * @(#)LadderGame.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.game;

import ladder.model.game.GameResult;
import ladder.model.ladder.Floor;
import ladder.model.ladder.Ladder;
import ladder.model.tags.PlayerTags;
import ladder.model.tags.ResultTags;
import ladder.model.tags.Tag;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class LadderGame {
    /*사다리 게임을 진행하고 결과를 추출하는 클래스*/
    private static final String NO_MATCHED_PLAYER_TAG_ERROR = "일치하는 플레이어 이름이 없습니다.";

    private Ladder ladder;
    private PlayerTags playerTags;
    private ResultTags resultTags;

    public Ladder getLadder() {
        return ladder;
    }

    public PlayerTags getPlayerTags() {
        return playerTags;
    }

    public ResultTags getResultTags() {
        return resultTags;
    }

    public LadderGame(PlayerTags playerTags, ResultTags resultTags, Floor floor) {
        this.playerTags = playerTags;
        this.resultTags = resultTags;
        ladder = new Ladder(floor, playerTags.getTagsNumber());
    }

    public Tag getOneResultByTag(Tag tag) {
        checkNoMatchPlayerTag(tag);
        int index = ladder.findResultTagIndexByIndex(playerTags.getIndexByTag(tag));
        return resultTags.getTagByIndex(index);
    }

    private void checkNoMatchPlayerTag(Tag tag) {
        if (!playerTags.getTags().contains(tag)) {
            throw new IllegalArgumentException(NO_MATCHED_PLAYER_TAG_ERROR);
        }
    }

    public GameResult getAllResults() {
        GameResult gameResult = new GameResult();
        for (Tag tag : playerTags.getTags()) {
            gameResult.addResult(tag, getOneResultByTag(tag));
        }
        return gameResult;
    }
}
