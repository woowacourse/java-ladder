package laddergame.fixture;

import laddergame.domain.Names;

import java.util.ArrayList;
import java.util.List;

public abstract class NamesFixture {
    public static Names createNames(final int size) {
        final List<String> nameValues = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            nameValues.add("name" + count);
        }
        return new Names(nameValues);
    }
}
