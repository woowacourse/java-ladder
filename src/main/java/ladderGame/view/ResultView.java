package ladderGame.view;

import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;

public class ResultView {
    private static final String RESULT_PROMPT = "실행 결과";
    public void printResultPrompt() {
        System.out.println(System.lineSeparator() + RESULT_PROMPT + System.lineSeparator());
    }

    public void printPlayerNames(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%6s", player.getName());
        }
        System.out.println();
    }

}
