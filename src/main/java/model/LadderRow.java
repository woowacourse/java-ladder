package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRow {

    private final List<Space> spaces;

    public LadderRow(List<Boolean> spaces) {
        verifyContinuousLine(spaces);
        this.spaces = spaces.stream()
                .map(Space::of)
                .toList();
    }

    private void verifyContinuousLine(List<Boolean> spaces) {
        for (int i = 1; i < spaces.size(); i++) {
            replaceContinuousLine(spaces, i);
        }
    }

    private void replaceContinuousLine(List<Boolean> spaces, int index) {
        if (spaces.get(index) && spaces.get(index - 1)) {
            spaces.set(index, false);
        }
    }

    public List<Space> getSpaces() {
        return new ArrayList<>(spaces);
    }
}
