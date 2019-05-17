package laddergame.domain;

public class Tag {
    private static final int TAG_LENGTH_BOUND = 5;

    private final String name;

    public Tag(final String name) {
        checkTag(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkTag(String tag) {
        if (tag == null || tag.equals("")) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
        if (tag.length() > TAG_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }
}
