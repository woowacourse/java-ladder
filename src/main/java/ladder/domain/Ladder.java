package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사다리타기 로직을 구현할 때 사다리의 가로 행 하나를 하나의 Row로 추상화하고 전체 사다리를 Row의 집합인 Rows로 추상화하였습니다. 직관적인 사다리의 형태에서 양 끝의
 * 막대(stick)가 있고 그 사이에 공간이 있다고 할 때, 우리는 막대 기준이 아닌 공간을 기준으로 Step이 연결된 여부를 정의했습니다. 로직 구현을 위해 아무 것도
 * 연결되어 있지 않은 첫 번째 인덱스의 값을 버퍼로 넣어주었습니다. 예를 들어, |-----|     |     | 이와 같은 사다리 Row가 있을 때 실제 우리가 구상한
 * 사다리 형태는 |xxxxx|-----|     |     |라고 할 수 있습니다. (x로 처리된 부분은 형식 상으로만 Step.BLANK 값으로 정의된, 의미없는
 * 데이터입니다.) 이 경우 Row에 정의되어 있는 List<Step> connected의 내용은 {Step.BLANK,Step.CONNECTED,Step.BLANK,Step.BLANK}가
 * 되고, 출력 시에는 첫번째 인덱스의 값을 무시합니다.
 */
public class Ladder {

    private final List<Row> rows;

    public Ladder(int height, int width, StepGenerator stepGenerator) {
        new Height(height);
        rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(new Row(width));
        }
        rows.forEach(row -> row.generateStep(stepGenerator));
    }


    public int followLadder(int initPosition) {
        int currentPosition = initPosition;
        for (int i = 0; i < rows.size(); i++) {
            currentPosition = rows.get(i).findAdjacentIndex(currentPosition);
        }
        return currentPosition;
    }


    public List<List<Step>> getRows() {
        return rows.stream()
            .map(Row::toDto)
            .collect(Collectors.toList());
    }
}
