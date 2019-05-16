/*
 * @(#)ResultTags.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

import ladder.domain.frame.Tags;

/**
 * Result 의 Tag 들을 저장하고 Result 전용 로직을 수행하기 위한 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 * @see Tags
 */
public class ResultTags extends Tags {
    private static final String PLAYERS_RESULTS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";

    public ResultTags(String input, int playerNumbers) {
        super(input);
        checkValidNumbers(playerNumbers);
    }

    public Tag get(int index) {
        return tags.get(index);
    }

    private void checkValidNumbers(int playerNumbers) {
        if (tags.size() != playerNumbers) {
            throw new IllegalArgumentException(PLAYERS_RESULTS_NUMBER_ERROR);
        }
    }

    @Override
    public void add(String name) {
        tags.add(new Tag(name));
    }
}
