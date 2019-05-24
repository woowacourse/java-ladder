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
    private static final int FIRST_INDEX = 0;
    private static final int EXCEPT_LAST_INDEX = 1;
    private static final int BEFORE = 1;

    private List<Point> horizontal;

    public Horizontal(LadderWidth width) {
        horizontal = new ArrayList<>();
        generateHorizontal(width);
    }

    public List<Point> getHorizontal() {
        return horizontal;
    }

    public Point get(int index) {
        return horizontal.get(index);
    }

    private void generateHorizontal(LadderWidth width) {
        for (int i = FIRST_INDEX; i < width.getLadderWidth(); i++) {
            addFirst(i);
            addMiddle(width, i);
            addLast(width, i);
        }
    }

    private void addFirst(int i) {
        if (i == FIRST_INDEX) {
            horizontal.add(Point.first());
        }
    }

    private void addMiddle(LadderWidth width, int i) {
        if (i != FIRST_INDEX && i != width.getLadderWidth() - EXCEPT_LAST_INDEX) {
            horizontal.add(horizontal.get(i - BEFORE).next());
        }
    }

    private void addLast(LadderWidth width, int i) {
        if (i == width.getLadderWidth() - EXCEPT_LAST_INDEX) {
            horizontal.add(horizontal.get(i - BEFORE).last());
        }
    }
}
