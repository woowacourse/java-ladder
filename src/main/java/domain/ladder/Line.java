package domain.ladder;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Step> steps = new ArrayList<>();
    private final BooleanGenerator generator;
    private final Integer width;

    private Line(BooleanGenerator generator, Integer width) {
        this.generator = generator;
        this.width = width;
    }

    public static Line of(final int width, final BooleanGenerator generator) {
        return new Line(generator, width);
    }

    public boolean isConnectedToRight(final int index) {
        return this.steps.get(index).isConnectedToRight();
    }

    public boolean isConnectedToLeft(int index) {
        return this.steps.get(index).isConnectedToLeft();
    }

    public void generateSteps() {
        // 첫 발판! -> 왼쪽으로 연결되었다는 선택지가 없음
        steps.add(Step.makeWithRightCondition(generator.generate()));

        // 중간 발판! -> 왼쪽, 오른쪽, 독립 세 가지 선택지
        while (!isLastStep()) {
            if (isConnectedWithPrevious()) {
                steps.add(Step.makeLeft());
                continue;
            }
            steps.add(Step.makeWithRightCondition(generator.generate()));
        }

        // 마지막 발판! -> 오른쪽으로 연결되었다는 선택지가 없음
        if (isConnectedWithPrevious()) {
            steps.add(Step.makeLeft());
            return;
        }
        steps.add(Step.makeNone());
    }

    public List<Boolean> getConnectedToRightConditions(){
        List<Boolean> conditions = new ArrayList<>();
        for (int index = 0; index < steps.size() - 1; index++) {
            conditions.add(steps.get(index).isConnectedToRight());
        }
        return conditions;
    }

    private boolean isConnectedWithPrevious() {
        return getPreviousStep().isConnectedToRight();
    }

    private boolean isLastStep() {
        return this.width - 1 == this.steps.size();
    }

    private Step getPreviousStep() {
        return this.steps.get(this.steps.size() - 1);
    }


    @Override
    public boolean equals(Object line) {
        if (this == line) return true;
        if (line == null || getClass() != line.getClass()) return false;
        Line anotherLine = (Line) line;
        return this.steps.equals(anotherLine.steps) && this.generator.equals(anotherLine.generator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps, generator);
    }

    @Override
    public String toString() {
        return "Line{" +
                "footSteps=" + steps +
                ", generator=" + generator +
                '}';
    }
}
