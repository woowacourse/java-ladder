package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMapGenerator {
    static ArrayList<List<Boolean>> fillLadderMap(int width, int height) {
        ArrayList<List<Boolean>> ladderMap = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladderMap.add(LIneGenerator.makeLine(width));
        }

        return ladderMap;
    }
}