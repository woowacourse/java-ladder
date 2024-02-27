package laddergame.view;

import laddergame.domain.LadderGame;
import laddergame.domain.gameelements.people.Name;
import laddergame.domain.gameelements.people.People;
import laddergame.domain.gameelements.results.Results;
import laddergame.domain.ladder.Ladder;

public class ResultView {
    private static final String LINE_SEPERATOR = System.lineSeparator();
    private static final String CALL_ALL_PLAYER_RESULTS_MESSAGE = "all";

    private ResultView() {
    }

    public static void printLadder(People people, Ladder ladder, Results results) {
        System.out.println(LINE_SEPERATOR + "실행 결과" + LINE_SEPERATOR);
        System.out.println(MessageResolver.resolveElementMessage(people));
        System.out.println(MessageResolver.resolveLadderMessage(ladder));
        System.out.println(MessageResolver.resolveElementMessage(results));
    }

    public static void printPlayerResult(String playerName, LadderGame ladderGame) {
        if (playerName.equals(CALL_ALL_PLAYER_RESULTS_MESSAGE)) {
            System.out.println(MessageResolver
                    .resolveAllPlayerResultMessage(ladderGame.getPlayerGameResult()));
            return;
        }
        System.out.println(MessageResolver
                .resolvePlayerResultMessage(ladderGame.findPlayerResult(new Name(playerName))));
    }

}
