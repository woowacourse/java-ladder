package ladder;

import ladder.controller.LadderController;
import ladder.util.RandomBooleanGenerator;

public class Application {
    // TODO: 2023/02/22 view에서 검증하는 로직 도메인으로 가져올 것, 리드미 수정할 것
    // TODO: 2023/02/23 테스트코드 given//when//then 
    public static void main(String[] args) {
        new LadderController(new RandomBooleanGenerator()).execute();
    }
}
