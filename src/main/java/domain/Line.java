package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> line;

    public Line (int height) {
        validateRange(height);
        this.line = new ArrayList<>(Collections.nCopies(height, false));
    }

    private void validateRange(int height) {
        if (height < 1 || height > 50) {
            throw new IllegalArgumentException("숫자는 1 이상 50 이하여야 합니다.");
        }
    }
}
