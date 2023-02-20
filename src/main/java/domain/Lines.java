package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class Lines {
    
    private final List<Line> lines;

    public Lines(int personCount, int height) {
        validateLadderHeight(height);
        this.lines = createLines(personCount, height);
    }

    private void validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 최소 높이는 1이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> createLines(int personCount, int height) {
        List<Line> lines = new ArrayList<>();
        while (height-- > 0) {
            lines.add(new Line(personCount));
        }
        return lines;
    }


}
