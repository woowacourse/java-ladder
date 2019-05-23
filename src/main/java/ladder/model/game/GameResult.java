/*
 * @(#)GameResult.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.game;

import ladder.model.tags.Tag;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class GameResult {
        /*게임 결과에 관련 된 클래스*/
        private LinkedHashMap<Tag, Tag> mappingResult;

        public GameResult() {
                mappingResult = new LinkedHashMap<>();
        }

        public void addResult(Tag inTag, Tag outTag) {
                mappingResult.put(inTag, outTag);
        }

        public LinkedHashMap<Tag, Tag> getMappingResult() {
                return mappingResult;
        }
}
