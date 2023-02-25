package ladder;

import ladder.controller.LadderController;
import ladder.util.RandomBooleanGenerator;

public class Application {
    // TODO: 2023/02/25 결과 입력할 때 검증 순서 변경
    public static void main(String[] args) {
        new LadderController(new RandomBooleanGenerator()).execute();
    }
}
