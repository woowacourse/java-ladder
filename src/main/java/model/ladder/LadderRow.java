package model.ladder;

import model.position.Position;

import java.util.ArrayList;
import java.util.List;

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

    public Position climb(Position position) {
        if (isEitherEnd(position)) {
            return climbOnEnd(position);
        }
        return climbOnMiddle(position);
    }

    private boolean isEitherEnd(Position position) {
        return position.same(0) || position.same(spaces.size());
    }

    private Position climbOnEnd(Position position) {
        if (position.same(0)) {
            return climbRight(position);
        }
        return climbLeft(position);
    }

    private Position climbOnMiddle(Position position) {
        if (!climbLeft(position).equals(position)) {
            return position.prior();
        }
        return climbRight(position);
    }

    private Position climbRight(Position position) {
        if (spaces.get(position.index()) == Space.LINE) {
            return position.next();
        }
        return position;
    }

    private Position climbLeft(Position position) {
        if (spaces.get(position.priorIndex()) == Space.LINE) {
            return position.prior();
        }
        return position;
    }

}
