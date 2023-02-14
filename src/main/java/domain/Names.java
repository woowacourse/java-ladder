package domain;

import java.util.Collections;
import java.util.List;

public class Names {
    public Names(List<String> names) {
        names.forEach(name -> {
            if (Collections.frequency(names, name) > 1) {
                throw new IllegalArgumentException("중복된 사람은 참여할 수 없습니다.");
            }
        });
    }
}
