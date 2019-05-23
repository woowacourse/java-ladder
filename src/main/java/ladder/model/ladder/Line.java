/*
 * @(#)Line.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */
package ladder.model.ladder;

import java.util.List;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class Line {
        /*사다리게임의 각 층(라인)에 대한 클래스*/
        private List<Horizon> horizons;

        public Line(List<Horizon> horizons){
                this.horizons = horizons;
        }

        public List<Horizon> getHorizons() {
                return horizons;
        }

        public int getIndexAfterMovingHorizon(int index) {
                return index + horizons.get(index).move();
        }
}
