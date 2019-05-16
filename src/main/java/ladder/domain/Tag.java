/*
 * @(#)Tag.java
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

import java.util.Objects;

/**
 * Player 와 Result 의 이름과 로직을 담당하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Tag {
    private static final String NAME_CONTAIN_SPACE_ERROR = "공백 포함 오류";
    private static final String NAME_LENGTH_ERROR = "길이 5 초과 오류";
    private static final String EMPTY_NAME_ERROR = "공백 입력 불가 오류";
    private static final String WHITE_SPACE = " ";
    private static final int NAME_UPPER_BOUND = 5;
    private static final int NAME_LOWER_BOUND = 0;

    private String name;

    public Tag(String name) {
        checkEmptyName(name);
        checkNameLength(name);
        checkNameContainSpace(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkEmptyName(String name) {
        if (name.length() == NAME_LOWER_BOUND) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_UPPER_BOUND) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void checkNameContainSpace(String name) {
        if(name.contains(WHITE_SPACE)){
            throw new IllegalArgumentException(NAME_CONTAIN_SPACE_ERROR);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag that = (Tag) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
