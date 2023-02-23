package laddergame.fixture;

import laddergame.domain.Name;

public abstract class NameFixture {
    public static Name createName(final String value) {
        return new Name(value);
    }
}
