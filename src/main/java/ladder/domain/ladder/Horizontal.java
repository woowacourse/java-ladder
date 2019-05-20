/*
 * @(#)Horizontal.java
 *
 * v 1.0.0
 *
 * 2019.05.16
 *
 * Copyright (c) 2019 MrKwon and men7627.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

/**
 * 사다리 가로줄을 담당하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Horizontal {
    private static final String HEADER_HORIZONTAL_LINE = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String NEW_LINE = "\n";

    private List<Point> horizontal;

    public Horizontal(LadderWidth width) {
        horizontal = new ArrayList<>();
        generateHorizontal(width);
    }

    public Point get(int index) {
        return horizontal.get(index);
    }

    private void generateHorizontal(LadderWidth width) {
        for (int i = 0; i < width.getLadderWidth(); i++) {
            addFirst(i);
            addMiddle(width, i);
            addLast(width, i);
        }
    }

    private void addFirst(int i) {
        if (i == 0) {
            horizontal.add(Point.first());
        }
    }

    private void addMiddle(LadderWidth width, int i) {
        if (i != 0 && i != width.getLadderWidth() - 1) {
            horizontal.add(horizontal.get(i - 1).next());
        }
    }

    private void addLast(LadderWidth width, int i) {
        if (i == width.getLadderWidth() - 1) {
            horizontal.add(horizontal.get(i - 1).last());
        }
    }

    // TODO 제거해야 할 부분
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER_HORIZONTAL_LINE);
        for (int i = 1; i < this.horizontal.size(); i++) {
            sb.append(VERTICAL_LINE)
                    .append(horizontal.get(i).toString());
        }
        sb.append(VERTICAL_LINE + NEW_LINE);
        return sb.toString();
    }
}
