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
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public abstract class Tags {
    /*사다리게임의 태그그룹에 대한 추상클래스*/
    protected static final String DELIMITER = ",";

    protected List<Tag> tags;

    protected Tags() {
        tags = new ArrayList<>();
    }

    public List<Tag> getTags() {
        return tags;
    }

    protected abstract void addTags(String[] input);
}
