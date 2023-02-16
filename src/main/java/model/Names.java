package model;

import java.util.Collections;
import java.util.List;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public String getNameOfIndex(int index) {
        Name target = names.get(index);

        return target.getName();
    }

    public int getTotalParticipantSize() {
        return names.size();
    }
}
