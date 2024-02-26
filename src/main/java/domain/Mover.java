package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mover {
    private final Lines lines;
    private final Names names;

    public Mover(final Lines lines, final Names names) {
        this.lines = lines;
        this.names = names;
    }

    public List<String> getMoveResult() {
        List<Integer> movableIndex = lines.getAllMovablePointIndexes();
        List<String> allNames = new ArrayList<>(names.getAll());

        for (int nextMovableIndex : movableIndex) {
            Collections.swap(allNames, nextMovableIndex, nextMovableIndex + 1);
        }

        return Collections.unmodifiableList(allNames);
    }
}
