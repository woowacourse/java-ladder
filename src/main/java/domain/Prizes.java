package domain;

import java.util.List;

public class Prizes {
    private final List<String> names;

    public Prizes(List<String> names) {
        validate(names);
        this.names = names;
    }

    private void validate(List<String> names) {
        for (String name : names) {
            new PrizeName(name);
        }
    }

    public String getName(int index) {
        return names.get(index);
    }

    public List<String> getNames() {
        return names;
    }

    public boolean isSame(int count) {
        return names.size() == count;
    }

}
