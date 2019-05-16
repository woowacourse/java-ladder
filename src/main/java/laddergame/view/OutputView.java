package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.player.Players;
import laddergame.domain.result.Results;

public class OutputView {

    private OutputView() {

    }

    public static void showPlayers(Players players){
        System.out.println("실행 결과");
        System.out.println(players);
    }

    public static void showLadder(Ladder ladder){
        System.out.println(ladder);
    }

    public static void showResult(Results results) {
        System.out.println(results);
    }
}
