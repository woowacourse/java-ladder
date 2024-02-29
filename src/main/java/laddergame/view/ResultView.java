package laddergame.view;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.Name;
import laddergame.domain.gameelements.Players;
import laddergame.domain.gameelements.Prizes;
import laddergame.domain.ladder.Ladder;

import static laddergame.view.MessageResolver.*;

public class ResultView {
    private static final String LINE_SEPERATOR = System.lineSeparator();
    private static final String CALL_ALL_PLAYER_RESULTS_MESSAGE = "all";

    private ResultView() {
    }

    //TODO StringBuilder 사용해보기
    //TODO 추후의 MessageResolver와의 통합 생각해보기
    public static void printLadder(Players upperPlayers, Ladder ladder, Prizes prizes) {
        System.out.println(LINE_SEPERATOR + "사다리 결과" + LINE_SEPERATOR);
        System.out.println(resolvePlayerMessage(upperPlayers));
        System.out.println(resolveLadderMessage(ladder));
        System.out.println(resolvePrizeMessage(prizes));
    }

    public static void printPlayerResult(String playerName, LadderGame ladderGame) {
        System.out.println(LINE_SEPERATOR + "실행 결과");

        if (playerName.equals(CALL_ALL_PLAYER_RESULTS_MESSAGE)) {
            System.out.println(resolveAllPlayerResultMessage(ladderGame.getPlayerGameResult()));
            return;
        }

        System.out.println(resolvePlayerResultMessage(ladderGame.findPlayerResult(new Name(playerName))));
    }

}
