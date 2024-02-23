package domain;

import java.util.Arrays;
import java.util.List;

public record Names(List<Name> names) {
    public Names(String[] names) {
        this(Arrays.stream(names).map(Name::new).toList());
    }
}
