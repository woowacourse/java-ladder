package domain;

import java.util.List;

public class Line {

    private final List<LineStatus> lineStatuses;

    public Line(List<LineStatus> lineStatuses) {
        validateEmptyLineStatus(lineStatuses);
        this.lineStatuses = lineStatuses;
    }

    private void validateEmptyLineStatus(List<LineStatus> lineStatuses){
        if (lineStatuses.isEmpty()) {
            throw new NullPointerException("[ERROR] 빈 리스트로 Line을 생성할 수 없습니다.");
        }
    }

    public List<LineStatus> getLineStatuses() {
        return this.lineStatuses;
    }
}
