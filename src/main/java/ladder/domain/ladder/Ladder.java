/*
 * @(#)Ladder.java
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
 * 사다리를 만들고 그와 관련된 로직을 관리하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Ladder {
    private List<Line> ladder;

    public Ladder(Height height, int playerNumber) {
        ladder = new ArrayList<>();
        for (int i = 0; i < height.getFloor(); i++) {
            ladder.add(new Line(playerNumber));
        }
    }

    public int getPlayerResult(int playerIndex){
        for(Line line : ladder){
            playerIndex = moveVertical(line, playerIndex);
        }
        return playerIndex;
    }

    private int moveVertical(Line line, int index){
        return line.moveHorizontal(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : this.ladder) {
            sb.append(line.toString());
        }
        return sb.toString();
    }
}
