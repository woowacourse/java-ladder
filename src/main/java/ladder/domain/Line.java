package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Stick> sticks;

    public Line(List<Stick> sticks) {
        validate(sticks);

        this.sticks = sticks;
    }

    private void validate(List<Stick> sticks) {
        validateIsNotEmpty(sticks);
        validateIsNotOverlapped(sticks);
    }

    private void validateIsNotEmpty(List<Stick> sticks) {
        if (sticks.isEmpty()) {
            throw new IllegalArgumentException("적어도 가로 라인이 하나이상 있어야 한다.");
        }
    }

    private void validateIsNotOverlapped(List<Stick> sticks) {
        for (int i = 1; i < sticks.size(); i++) {
            Stick before = sticks.get(i - 1);
            Stick current = sticks.get(i);
            validateBothExist(before, current);
        }

    }

    private void validateBothExist(Stick before, Stick current) {
        if (current.isExist() && before.isExist()) {
            throw new IllegalArgumentException("가로 라인이 이어지면 안된다.");
        }
    }

    public boolean isExist(int position) {
        return sticks.get(position).isExist();
    }

    public List<Stick> getSticks() {
        return Collections.unmodifiableList(sticks);
    }

    public int getWidth() {
        return sticks.size();
    }

    public Line addGap() {
        List<Stick> copyOfSticks = new ArrayList<>(sticks);
        copyOfSticks.add(0, Stick.NON_EXISTENCE);
        copyOfSticks.add(copyOfSticks.size(), Stick.NON_EXISTENCE);

        return new Line(copyOfSticks);
    }

    public int move(int index) {
        List<Stick> sticks = this.getSticks();
        if (sticks.get(index + 1).isExist()) {
            return index + 1;
        }
        if (sticks.get(index).isExist()) {
            return index - 1;
        }
        return index;
    }
}
