package ladder.domain.gamecomponent;

import ladder.domain.laddercomponent.Step;
import ladder.domain.laddercomponent.Steps;

import java.util.List;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int judgeMove(Steps steps) {
        List<Step> stepList = steps.getSteps();

        if (position == 0) {
            return (stepList.get(position).exist() ? moveRight() : position);
        }
        if (position == stepList.size()) {
            return (stepList.get(position - 1).exist() ? moveLeft() : position);
        }
        if (stepList.get(position - 1).exist()) {
            return moveLeft();
        }
        return (stepList.get(position).exist() ? moveRight() : position);
    }

    private int moveLeft() {
        position--;
        return position;
    }

    private int moveRight() {
        position++;
        return position;
    }

    public int getPosition() {
        return position;
    }
}
