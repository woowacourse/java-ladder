/*
 * @(#)OutputView.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */
package ladder.view;

import ladder.model.game.GameResult;
import ladder.model.game.LadderGame;
import ladder.model.ladder.Line;
import ladder.model.tags.Tag;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class OutputView {
    /*사다리게임의 출력에 대한 클래스*/
    private static final String LADDER_TITLE_MESSAGE = "사다리 결과";
    private static final String RESULT_TITLE_MESSAGE = "실행 결과";
    private static final String HEADER_HORIZON_LINE = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String NEW_LINE = "\n";
    private static final String NO_HORIZON_LINE = "     ";
    private static final String HORIZON_LINE = "-----";
    private static final String SPACE_COLON_SPACE = " : ";

    public static void PrintLadderTitle() {
        System.out.println(LADDER_TITLE_MESSAGE);
    }

    public static void PrintResultTitle() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void PrintOneResult(Tag tag) {
        System.out.println(tag.getValue());
    }

    public static void PrintAllResult(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        for(Tag inTag : gameResult.getMappingResult().keySet()){
            sb.append(inTag.getValue())
                    .append(SPACE_COLON_SPACE)
                    .append(gameResult.getMappingResult().get(inTag).getValue())
                    .append(NEW_LINE);
        }
        System.out.println(sb.toString());
    }

    public static void PrintTagsAndLadder(LadderGame ladderGame) {
        System.out.println(toStringPlayerTags(ladderGame) + toStringLadder(ladderGame) + toStringResultTags(ladderGame));
    }

    private static String toStringPlayerTags(LadderGame ladderGame) {
        StringBuilder sb = new StringBuilder();
        for (Tag tag : ladderGame.getPlayerTags().getTags()) {
            sb.append(String.format("%6s", tag.getValue()));
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }

    private static String toStringLadder(LadderGame ladderGame) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladderGame.getLadder().getLines()) {
            sb.append(HEADER_HORIZON_LINE);
            sb.append(toStringEachLine(line));
        }
        return sb.toString();
    }

    private static String toStringEachLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Boolean horizon : line.getHorizons()) {
            sb.append(VERTICAL_LINE);
            sb.append(toStringEachHorizon(horizon));
        }
        sb.append(VERTICAL_LINE).append(NEW_LINE);
        return sb.toString();
    }

    private static String toStringEachHorizon(Boolean horizon) {
        if (horizon) {
            return HORIZON_LINE;
        }
        return NO_HORIZON_LINE;
    }

    private static String toStringResultTags(LadderGame ladderGame) {
        StringBuilder sb = new StringBuilder();
        for (Tag tag : ladderGame.getResultTags().getTags()) {
            sb.append(String.format("%6s", tag.getValue()));
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }
}
