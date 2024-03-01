package view;

import dto.LadderGameResult;

public class LadderGameResultPrinter {
    static String from(LadderGameResult ladderGameResult) {
        return "%s : %s".formatted(ladderGameResult.playerName(), ladderGameResult.giftName());
    }
}
