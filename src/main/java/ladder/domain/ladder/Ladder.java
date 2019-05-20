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
import java.util.Iterator;
import java.util.List;

/**
 * 사다리를 만들고 그와 관련된 로직을 관리하는 클래스
 *
 * @author mrkwon
 * @author men7627
 * @version 1.0.0
 */
public class Ladder implements Iterable<Horizontal> {
    private List<Horizontal> ladder;

    public Ladder(LadderHeight height, LadderWidth width) {
        this.ladder = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Horizontal(width));
        }
    }

    public List<Horizontal> getLadder() {
        return ladder;
    }

    public Position moveToResult(int startIndex){
        Position current = new Position(startIndex);
        for (Horizontal horizontal : ladder) {
            current = current.move(horizontal.get(current.getPosition()));
        }
        return current;
    }

    @Override
    public Iterator<Horizontal> iterator() {
        return ladder.iterator();
    }
}
