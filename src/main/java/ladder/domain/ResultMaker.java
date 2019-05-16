package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class ResultMaker {
    public static int generateResult(List<Line> ladder, int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }
        return index;
    }

    public static List<Integer> generateResultAll(List<Line> ladder, int countOfPerson) {
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            resultIndex.add(generateResult(ladder, i + 1));
        }
        return resultIndex;
    }
}
