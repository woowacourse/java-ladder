/*
 * @(#)Tags.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.tags;


import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0 2019년 05년 16일
 * @author 김효건
 */
public abstract class Tags {
    /*사다리게임의 태그그룹에 대한 추상클래스*/
    private static final String NOT_VALID_INPUT_ERROR = "입력 형식 오류";
    private static final String INPUT_REGEX = "^([^,]+)(,[^,]+)*$";
    protected static final String DELIMITER = ",";

    protected List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    protected Tags(String input) {
        tags = new ArrayList<>();
        checkValidInput(input);
    }

    private void checkValidInput(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException(NOT_VALID_INPUT_ERROR);
        }
    }

    protected abstract void addTags(String tag);
}
