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
}
