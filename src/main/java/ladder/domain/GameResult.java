/*
 * @(#)GameResult.java
 *
 * v 1.1.0
 *
 * 2019.05.20
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ladder.domain.tag.Tag;

/**
 * 게임 결과와 그와 관련된 로직을 수행하기 위한 클래스
 *
 * @author kwonmc
 * @version 1.1.0
 */
public class GameResult implements Iterable<Map.Entry<Tag, Tag>> {
    private static final String GET_ONE_PLAYER_ERROR = "일치하는 플레이어 이름이 없습니다.";

    private Map<Tag, Tag> gameResult;

    GameResult() {
        gameResult = new HashMap<>();
    }

    void put(Tag name, Tag result) {
        gameResult.put(name, result);
    }

    public Tag get(Tag name) {
        validName(name);
        return gameResult.get(name);
    }

    private void validName(Tag name) {
        if (gameResult.get(name) == null) {
            throw new IllegalArgumentException(GET_ONE_PLAYER_ERROR);
        }
    }

    @Override
    public Iterator<Map.Entry<Tag, Tag>> iterator() {
        return gameResult.entrySet().iterator();
    }
}