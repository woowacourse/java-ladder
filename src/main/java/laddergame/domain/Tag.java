package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Tag {
    public static final int TAG_LENGTH_BOUND = 5;

    private final String name;

    public Tag(final String name) {
        checkTag(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkTag(final String tag) {
        if (StringUtils.isBlank(tag)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
        if (tag.length() > TAG_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
