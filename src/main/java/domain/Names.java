package domain;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private static final int FIRST_NAME_INDEX = 0;
    
    private final List<Name> names;

    public Names(final List<Name> names) {
        this.names = new ArrayList<>(names);
    }

    public int firstNameLength() {
        return names.get(FIRST_NAME_INDEX).length();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    public int size() {
        return names.size();
    }
}
