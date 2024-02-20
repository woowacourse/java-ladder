package domain;

import utils.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    List<Line> lines = new ArrayList<>();

    public Ladder(int height, int participantsCount) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(participantsCount - 1, new RandomBooleanGenerator()));
        }
    }
}
