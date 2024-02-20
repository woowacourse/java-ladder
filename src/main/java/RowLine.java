import java.util.Collections;
import java.util.List;
//TODO package 이동
public class RowLine {
    private final List<Boolean> line;

    RowLine(int peopleNumber, LineGenerator generator) {
        // TODO Validate로 빽;
        // TODO MIN, MAX값 상수화
        // TODO  deepcopy로 안전성 높이기
        if (peopleNumber < 1 || peopleNumber > 100) {
            throw new IllegalArgumentException("참여자 수는 1이상 100이하의 사람 수 입니다.");
        }
        List<Boolean> line = generator.getLine(peopleNumber);
        validateSuccessiveLine(line);
        this.line = line;
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }

    private void validateSuccessiveLine(List<Boolean> booleans) {
        Boolean flag = Boolean.FALSE;
        for (Boolean b : booleans) {
            if (flag && b) {
                throw new IllegalArgumentException("사다리 가로선이 연속되었습니다.");
            }
            flag = b;
        }
    }

}
