package laddergame.domain.ladder;

import java.util.Objects;
import laddergame.domain.name.Names;
import laddergame.exception.LadderGameException;

public class LineSize {

    private final int lineSize;

    public LineSize(final Names names) {
        validateSize(names);
        this.lineSize = names.size() - 1;
    }

    private void validateSize(final Names names) {
        if (names == null || names.size() == 0) {
            throw new LadderGameException("[ERROR] 참가자는 1명 이상이어야 합니다.");
        }
    }

    public int getLineSize() {
        return lineSize;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final LineSize lineSize1)) {
            return false;
        }
        return getLineSize() == lineSize1.getLineSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLineSize());
    }
}
