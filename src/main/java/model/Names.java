package model;

import exception.WrongParticipantSizeException;
import java.util.Collections;
import java.util.List;

public class Names {

    private static final int MINIMUM_PARTICIPANTS_SIZE = 2;

    private final List<Name> names;

    public Names(List<Name> names) {
        validateSize(names);

        this.names = names;
    }

    private void validateSize(List<Name> names) {
        if (names.size() < MINIMUM_PARTICIPANTS_SIZE) {
            throw new WrongParticipantSizeException();
        }
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
