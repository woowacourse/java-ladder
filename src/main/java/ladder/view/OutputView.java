/*
 * @(#)OutputView.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.view;

import java.util.Map;

import ladder.domain.GameResult;
import ladder.domain.LadderGame;
import ladder.domain.ladder.Horizontal;
import ladder.domain.ladder.Ladder;
import ladder.domain.tag.Tag;
import ladder.domain.tag.Tags;

/**
 * 사다리 게임 출력을 담당하는 View 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class OutputView {
    private static final String LADDER_TITLE = "사다리 결과";
    private static final String RESULT_TITLE = "실행 결과";
    private static final String TAG_FORMAT = "%6s";
    private static final String NO_HORIZONTAL_LINE = "     ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String MAP_FORMAT = "%s : %s";
    private static final String VERTICAL_LINE = "|";
    private static final String END_VERTICAL_LINE = "|\n";


    public static void ladderTitle() {
        System.out.println(LADDER_TITLE);
    }

    public static void ladderBody(LadderGame ladderGame) {
        ladderTags(ladderGame.getPlayers());
        ladderShape(ladderGame.getLadder());
        ladderTags(ladderGame.getResults());
    }

    private static void ladderTags(Tags tags) {
        StringBuilder sb = new StringBuilder();
        for (Tag tag : tags.getTags()) {
            sb.append(String.format(TAG_FORMAT, tag));
        }
        System.out.println(sb.toString());
    }

    private static void ladderShape(Ladder ladder) {
        StringBuilder sb = getLadderBuilder(ladder);
        System.out.println(sb.toString());
    }

    private static StringBuilder getLadderBuilder(Ladder ladder) {
        StringBuilder ladderBuilder = new StringBuilder();
        for (Horizontal horizontal : ladder) {
            StringBuilder horizontalBuilder = getHorizontalBuilder(horizontal);
            ladderBuilder.append(horizontalBuilder.toString());
        }
        return ladderBuilder;
    }

    private static StringBuilder getHorizontalBuilder(Horizontal horizontal) {
        StringBuilder horizontalBuilder = new StringBuilder();
        horizontalBuilder.append(NO_HORIZONTAL_LINE);
        for (int i = 1; i < horizontal.getHorizontal().size(); i++) {
            horizontalBuilder.append(VERTICAL_LINE)
                    .append(getHorizontalLine(horizontal, i));
        }
        horizontalBuilder.append(END_VERTICAL_LINE);
        return horizontalBuilder;
    }

    private static String getHorizontalLine(Horizontal horizontal, int i) {
        return horizontal.get(i).getLeft() ? HORIZONTAL_LINE : NO_HORIZONTAL_LINE;
    }

    public static void resultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void resultOneResult(Tag tag) {
        System.out.println(tag);
    }

    public static void resultGameResult(GameResult gameResult) {
        for (Map.Entry<Tag, Tag> map : gameResult) {
            System.out.println(String.format(MAP_FORMAT, map.getKey(), map.getValue()));
        }
    }
}
