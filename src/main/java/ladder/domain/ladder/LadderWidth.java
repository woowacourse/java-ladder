/*
 * @(#)LadderWidth.java
 *
 * v 1.1.0
 *
 * 2019.05.20
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCourse, Seoul, KOREA
 * All right Reserved
 */

package ladder.domain.ladder;

/**
 * 사다리 높이 래퍼 클래스
 *
 * @author kwonmc
 * @version 1.1.0
 */
public class LadderWidth {
    private static final String INVALID_WIDTH_ERROR = "플레이어 수는 2이상 입니다.";

    private int ladderWidth;

    public LadderWidth(int ladderWidth) {
        if (ladderWidth < 1) {
            throw new IllegalArgumentException(INVALID_WIDTH_ERROR);
        }
        this.ladderWidth = ladderWidth;
    }

    int getLadderWidth() {
        return ladderWidth;
    }
}
