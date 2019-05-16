/*
 * @(#)Tags.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain.frame;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.Tag;

/**
 * Tags 에 관련된 공통 변수와 공통 로직을 수행하기 위한 abstract 클래스
 *
 * @author mrkwon
 * @version 1.0.0
 */
public abstract class Tags {
    private static final String DELIMITER = ",";
    private static final String VALID_INPUT_ERROR = "입력 형식 오류";
    private static final String PLAYER_NAMES_REGEX = "^([^,]+)(,[^,]+)*$";

    protected List<Tag> tags;

    protected Tags(String input) {
        tags = new ArrayList<>();
        validInput(input);
        addNames(input);
    }

    private void validInput(String input) {
        if(!input.matches(PLAYER_NAMES_REGEX)){
            throw new IllegalArgumentException(VALID_INPUT_ERROR);
        }
    }

    public abstract void add(String name);

    protected void addNames(String input) {
        for (String name : input.split(DELIMITER)) {
            this.add(name);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Tag tag : tags){
            sb.append(String.format("%6s", tag.toString()));
        }
        return sb.toString();
    }
}
