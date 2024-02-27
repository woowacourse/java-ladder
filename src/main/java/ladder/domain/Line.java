package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.player.Player;

public class Line {

    private final List<Stick> sticks;

    public Line(List<Stick> sticks) {
        List<Stick> copiedSticks = List.copyOf(sticks);
        validate(copiedSticks);
        this.sticks = copiedSticks;
    }

    private void validate(List<Stick> sticks) {
        validateIsNotEmpty(sticks);
        validateIsNotOverlapped(sticks);
    }

    // TODO nullPointerException 처리하기
    private void validateIsNotEmpty(List<Stick> sticks) {
        if (sticks.isEmpty()) {
            throw new IllegalArgumentException("적어도 가로 라인이 하나이상 있어야 한다.");
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

    public List<Player> progressSwitching(List<Player> players) {
        // TODO players의 크기와 sticks의 크기 비교
        List<Player> result = new ArrayList<>(players);
        IntStream.range(0, sticks.size())
                .filter(index -> sticks.get(index).isExist())
                .forEach(index -> Collections.swap(result, index, index + 1));
        return result;
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
