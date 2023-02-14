package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private static final int MIN_NAME_SIZE = 2;

    private final List<Name> names;

    public Names(List<Name> names) {
        if (names.size() < MIN_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("[ERROR] 이름은 최소 2개 이상이여햡니다. 입력값 : %d", names.size()));
        }
        this.names = new ArrayList<>(names);
    }
}
