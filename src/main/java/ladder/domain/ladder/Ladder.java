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
    private List<Horizontal> ladder;
    private LadderHeight height;
    private LadderWidth width;

//    public Ladder(LadderHeight height, int playerNumber) {
//        this.ladder = new ArrayList<>();
//        this.height = height;
//        for (int i = 0; i < height.getHeight(); i++) {
//            ladder.add(new Horizontal(playerNumber));
//        }
//    }

    public Ladder(LadderHeight height, LadderWidth width) {
        this.ladder = new ArrayList<>();
        this.height = height;
        this.width = width;
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Horizontal(width));
        }
    }

//    public int getPlayerResult(int playerIndex){
//        for(Horizontal horizontal : ladder){
//            playerIndex = moveVertical(horizontal, playerIndex);
//        }
//        return playerIndex;
//    }

//    private int moveVertical(Horizontal horizontal, int index){
//        return horizontal.moveHorizontal(index);
//    }

    public Position moveToResult(int startIndex){
        Position currentPosition = new Position(startIndex, this.width.getLadderWidth());
        for (Horizontal horizontal : ladder) {
            currentPosition.move(horizontal.get(startIndex));
        }
        return currentPosition;
    }

    // TODO 제거해야 할 부분
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Horizontal horizontal : this.ladder) {
            sb.append(horizontal.toString());
        }
        return sb.toString();
    }
}
