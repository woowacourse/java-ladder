package laddergame.fixture;

import laddergame.domain.Name;
import laddergame.domain.Names;

import java.util.List;

public abstract class NamesFixture {
    public static Names createNamesSize2() {
        final List<Name> names = List.of(new Name("rosie"), new Name("hyena"));
        return new Names(names);
    }

    public static Names createNamesSize3() {
        final List<Name> names = List.of(new Name("rosie"), new Name("hyena"), new Name("jayon"));
        return new Names(names);
    }
}
