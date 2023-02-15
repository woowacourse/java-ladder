package laddergame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO: 추후 랜덤값 검사하는 테스트에 맞춰 리팩토링하기
public class Line {
    static final Random random = new Random();
    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        validateLine(line);
        this.line = line;
    }

    public Line(int personCount) {
        this(makeLine(personCount));
    }

    private static void validateLine(List<Boolean> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            validatePoint(line, i);
        }
    }

    private static void validatePoint(List<Boolean> line, int i) {
        if (line.get(i) && line.get(i + 1)) {
            throw new IllegalArgumentException("[ERROR] 라인에 연속되는 true값이 존재합니다.");
        }
    }

    private static List<Boolean> makeLine(int personCount) {
        List<Boolean> line = new ArrayList<>();

        line.add(random.nextBoolean());
        for (int i = 1; i < personCount - 1; i++) {
            makePoint(line, i);
        }
        return line;
    }

    private static void makePoint(List<Boolean> line, int i) {
        if (line.get(i - 1)) {
            line.add(false);
        }
        if (!line.get(i - 1)) {
            line.add(random.nextBoolean());
        }
    }

    public int getSize() {
        return line.size();
    }

    public List<Boolean> getLine() {
        return line;
    }
}
