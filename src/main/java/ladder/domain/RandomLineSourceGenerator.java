package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLineSourceGenerator implements LineSourceGenerator {

    @Override
    public LineSource generate() {
        List<LineSource> values = new ArrayList<>(List.of(LineSource.values()));
        Collections.shuffle(values);
        return values.get(0);
    }
}
