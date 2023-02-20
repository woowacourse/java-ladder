package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(List<String> names) {
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int getPersonCount() {
        return names.size();
    }
}
