package ladder.controller;

public class LadderGameApplication {
    public static void start() {
        LadderGame game = new LadderGame();
        LadderGameResult result = new LadderGameResult(game.play());
        result.requestResult();
    }
}