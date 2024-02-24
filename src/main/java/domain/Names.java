package domain;

import java.util.List;

public class Names {
    private final List<Name> names;

    Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }

    int getNameCount() {
        return names.size();
    }
}
