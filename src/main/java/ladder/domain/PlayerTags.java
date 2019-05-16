/*
 * @(#)PlayerTags.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain;

import java.util.List;

import ladder.domain.frame.Tags;

/**
 * Player 의 Tag 들을 저장하고 Player 전용 로직을 수행하기 위한 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 * @see Tags
 */
public class PlayerTags extends Tags {
    private static final String DUPLICATE_NAME_ERROR = "중복 이름 오류";

    public PlayerTags(String input) {
        super(input);
    }

    public List<Tag> getNames() {
        return tags;
    }

    public int size() {
        return tags.size();
    }

    public int indexOf(Tag tag) {
        return this.tags.indexOf(tag);
    }

    private void checkDuplicateName(String name) {
        if (tags.contains(new Tag(name))) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }

    @Override
    public void add(String name) {
        checkDuplicateName(name);
        this.tags.add(new Tag(name));
    }
}
