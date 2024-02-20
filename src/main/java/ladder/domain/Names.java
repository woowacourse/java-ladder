package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private final List<String> names;

    public Names(String rawNames) {
        String[] names = rawNames.split(",");
        this.names = new ArrayList<>(List.of(names));
    }
}
