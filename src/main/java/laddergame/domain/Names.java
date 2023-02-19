package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private static final int MIN_PARTICIPANTS_SIZE = 2;
    private static final String NAMES_NULL_EXCEPTION = "Name 리스트는 null일 수 없습니다.";
    private static final String PARTICIPANTS_MIN_SIZE_EXCEPTION = "참여자 이름 목록은 2명 미만이 될 수 없습니다.";

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateNames(names);
        this.names = names;
    }

    public int getSize() {
        return names.size();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    private void validateNames(List<Name> names) {
        if (names == null) {
            throw new IllegalArgumentException(NAMES_NULL_EXCEPTION);
        }
        if (names.size() < MIN_PARTICIPANTS_SIZE) {
            throw new IllegalArgumentException(PARTICIPANTS_MIN_SIZE_EXCEPTION);
        }
    }
}
