package model.ladder;

import static model.ladder.StepStatus.CONNECTED;

import java.util.ArrayList;
import java.util.List;
import model.ladder.generator.StepStatusGenerator;
import model.players.Position;

public class Line {
    private final List<Step> steps;

    public Line(List<Step> steps) {
        this.steps = steps;
    }

    public static Line from(final Width width, final StepStatusGenerator generator) {
        List<Step> steps = new ArrayList<>();
        Step previous = Step.from(StepStatus.EMPTY);
        while (steps.size() < width.size()) {
            Step step = Step.of(previous, generator);
            steps.add(step);
            previous = step;
        }
        return new Line(steps);
    }

    public int size() {
        return steps.size();
    }

    public boolean isConnected(final int index) {
        return steps.get(index).isStatus(CONNECTED);
    }

    public void move(Position position) {
        if (isFirst(position)) {
            if (getRightStep(position).isStatus(CONNECTED)) {
                position.moveRight();
                return;
            }
            return;
        }

        if (isLast(position)) {
            if (getLeftStep(position).isStatus(CONNECTED)) {
                position.moveLeft();
                return;
            }
            return;
        }

        if (getRightStep(position).isStatus(CONNECTED)) {
            position.moveRight();
            return;
        }
        if (getLeftStep(position).isStatus(CONNECTED)) {
            position.moveLeft();
        }
    }

    // TODO: Direction 클래스의 함수형 프로그래밍으로 개선하기
    private Step getRightStep(final Position position) {
        return steps.get(position.getValue());
    }

    private Step getLeftStep(final Position position) {
        return steps.get(position.getValue() - 1);
    }

    private boolean isFirst(final Position position) {
        return position.getValue() == 0;
    }

    private boolean isLast(final Position position) {
        // TODO: 일일이 인스턴스를 생성해서 값 비교를 해줘야 하는건가?
        return position.getValue() == steps.size();
        // return position.equals(steps.size());
    }
}
