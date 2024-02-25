package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

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
        if (isStickOverlapped(sticks)) {
            throw new IllegalArgumentException("가로 라인이 이어지면 안된다.");
        }
    }

    private boolean isStickOverlapped(List<Stick> sticks) {
        return IntStream.range(1, sticks.size())
                .anyMatch(i -> sticks.get(i).isExist() && sticks.get(i - 1).isExist());
    }

    public boolean isExist(int position) {
        if (position < 0 || position >= getWidth()) {
            throw new IllegalArgumentException("가로 위치가 범위를 벗어났습니다.");
        }
        return sticks.get(position).isExist();
    }

    public int getWidth() {
        return sticks.size();
    }
}
