package laddergame.fixture;

import laddergame.domain.Names;

import java.util.List;

public abstract class NamesFixture {
    public static Names getNamesSize2() {
        return new Names(List.of("rosie", "hyena"));
    }

    public static Names getNamesSize3() {
        return new Names(List.of("rosie", "hyena", "jayon"));
    }
}
