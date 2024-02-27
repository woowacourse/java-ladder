package ladder.domain;

import java.util.List;

public class Line {

    private final List<Stick> sticks;

    public Line(List<Stick> sticks) {
        validate(sticks);
        this.sticks = List.copyOf(sticks);
    }

    private void validate(List<Stick> sticks) {
        validateIsNotEmpty(sticks);
        validateIsNotOverlapped(sticks);
    }


    private void validateIsNotEmpty(List<Stick> sticks) {
        if (sticks == null || sticks.isEmpty()) {
            throw new IllegalArgumentException("적어도 가로 라인이 하나 이상 있어야 한다.");
        }
    }

    private void validateIsNotOverlapped(List<Stick> sticks) {
        for (int i = 1; i < sticks.size(); i++) {
            Stick before = sticks.get(i - 1);
            Stick current = sticks.get(i);
            validateIsNotOverlapped(before, current);
        }
    }

    private void validateIsNotOverlapped(Stick before, Stick current) {
        if (before.isExist() && current.isExist()) {
            throw new IllegalArgumentException("가로 라인이 이어지면 안된다.");
        }
    }

    public int findNextPosition(int playerPosition) {
        validatePlayerPosition(playerPosition);
        if (isExistLeftStick(playerPosition)) {
            return playerPosition - 1;
        }
        if (isExistRightStick(playerPosition)) {
            return playerPosition + 1;
        }
        return playerPosition;
    }

    private void validatePlayerPosition(int playerPosition) {
        if (playerPosition < 0 || playerPosition > getWidth()) {
            throw new IllegalArgumentException("플레이어의 위치가 사다리를 벗어났습니다.");
        }
    }

    private boolean isExistLeftStick(int playerPosition) {
        return playerPosition != 0 && sticks.get(playerPosition - 1).isExist();
    }

    private boolean isExistRightStick(int playerPosition) {
        return playerPosition != getWidth() && sticks.get(playerPosition).isExist();
    }

    public boolean isExist(int position) {
        validateStickPosition(position);
        return sticks.get(position).isExist();
    }

    private void validateStickPosition(int position) {
        if (position < 0 || position >= getWidth()) {
            throw new IllegalArgumentException("가로 위치가 범위를 벗어났습니다.");
        }
    }

    public int getWidth() {
        return sticks.size();
    }
}
