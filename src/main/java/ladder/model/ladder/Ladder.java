/*
 * @(#)Ladder.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.ladder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class Ladder {
        /*사다리게임의 사다리에 대한 클래스*/
        private List<Line> lines;

        public List<Line> getLines() {
                return lines;
        }

        public Ladder(List<Line> lines){
                this.lines = lines;
        }

        public int findResultTagIndexByIndex(int index) {
                for (Line line : lines) {
                        index = getIndexAfterMovingDown(line, index);
                }
                return index;
        }

        private int getIndexAfterMovingDown(Line line, int index) {
                return line.getIndexAfterMovingHorizon(index);
        }
}
