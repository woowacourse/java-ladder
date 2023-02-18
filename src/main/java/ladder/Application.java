package ladder;

import ladder.controller.LadderController;

public class Application {
    //질문 : ENUM 을 어디다 사용해야 하나요? view 를 enum 으로 바꾸는 방향인가요?
    //질문 : 형식1, 형식2 중에서 어떤 것이 더 좋은 방향인가요

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.run();
    }
}
