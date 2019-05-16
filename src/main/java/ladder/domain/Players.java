package ladder.domain;

import java.util.List;

public class Players extends NameContainer {
    private static final String DUPLICATE_NAME_ERROR = "중복 이름 오류";

    public Players(String input) {
        super(input);
    }

    public List<Name> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }

    public int indexOf(Name name) {
        return this.names.indexOf(name);
    }

    @Override
    public void add(String name) {
        checkDuplicateName(name);
        this.names.add(new Name(name));
    }

    private void checkDuplicateName(String name) {
        if (names.contains(new Name(name))) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
        }
    }
}
