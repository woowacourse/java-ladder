package domain;

import util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class Line {

    private final List<Boolean> line;

    public Line(int personCount) {
        this.line = createLine(personCount);
    }

    public List<Boolean> getLine() {
        return line;
    }

    private List<Boolean> createLine(int personCount) {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        List<Boolean> line = Collections.singletonList(new ArrayList<>().add(randomValueGenerator.getRandomValue()));
        while (personCount-- > 0) {
            if (!line.get(line.size() - 1)) line.add(randomValueGenerator.getRandomValue());
        }
        return line;
    }
}
