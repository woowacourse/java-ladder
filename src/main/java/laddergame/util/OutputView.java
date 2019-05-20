package laddergame.util;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameResult;
import laddergame.domain.Tag;

public class OutputView {
    public static void outputLadderGame(final LadderGame ladderGame) {
        System.out.println("사다리 결과");
        System.out.println(LadderGameViewMaker.makeTagsView(ladderGame.getMembers().getTagsName()));
        System.out.print(LadderGameViewMaker.makeLadderView(ladderGame.getLadder()));
        System.out.println(LadderGameViewMaker.makeTagsView(ladderGame.getPrizes().getTagsName()));
    }

    public static void outputLadderGameResult(final String person,
                                              final LadderGameResult ladderGameResult) {
        System.out.println("실행 결과");
        if ("all".equals(person)) {
            System.out.println(LadderGameViewMaker.makeGameResult(ladderGameResult.allPrizes()));
            return;
        }
        System.out.println(ladderGameResult.prize(new Tag(person)).getName());
    }
}
