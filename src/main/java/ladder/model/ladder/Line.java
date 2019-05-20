/*
 * @(#)Line.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */
package ladder.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class Line {
    /*사다리게임의 각 층(라인)에 대한 클래스*/
    private List<Horizon> horizons;
    private Random random;

    public Line(int tagsNumber) {
        random = new Random();
        horizons = new ArrayList<>();
        addFirstHorizon();
        for (int i = 1; i < tagsNumber - 1; i++) {
            horizons.add(new Horizon(horizons.get(i - 1), random.nextBoolean()));
        }
        addLastHorizon(tagsNumber);
    }

    private void addLastHorizon(int tagsNumber) {
        Horizon lastHorizon = new Horizon(horizons.get(tagsNumber - 2),false);
        horizons.add(lastHorizon);
    }

    private void addFirstHorizon() {
        Horizon firstHorizon = new Horizon(random.nextBoolean());
        horizons.add(firstHorizon);
    }

    public List<Horizon> getHorizons() {
        return horizons;
    }

    public int getIndexAfterMovingHorizon(int index) {
        return index + horizons.get(index).move();
    }
}
