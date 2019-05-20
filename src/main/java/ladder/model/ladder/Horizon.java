/*
 * @(#)Horizon.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.ladder;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 20일
 */
public class Horizon {
    /*사다리게임의 가로선에 대한 클래스*/
    private final static int MOVE_LEFT = -1;
    private final static int MOVE_RIGHT = 1;
    private final static int MOVE_NONE = 0;

    private boolean beforeValue;
    private boolean currentValue;

    public Horizon(Boolean value) {
        beforeValue = false;
        currentValue = value;
    }

    public Horizon(Horizon beforeHorizon, Boolean value) {
        beforeValue = beforeHorizon.hasHorizon();
        if(beforeValue) {
            currentValue = false;
            return;
        }
        currentValue = value;
    }

    public boolean hasHorizon() {
        return currentValue;
    }


    public int move() {
        if(beforeValue){
            return MOVE_LEFT;
        }
        if(currentValue){
            return MOVE_RIGHT;
        }
        return MOVE_NONE;
    }
}
