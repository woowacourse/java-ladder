package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.util.TrueGenerator;

class MatchingCalculatorTest {

    @ParameterizedTest(name = "참여자와 실행 결과를 매칭한다. - 사다리 높이 1")
    @ValueSource(ints = {1, 2, 3})
    void matchingCalculatorTest(int count) {
        String[] nameList = {"a", "b", "c", "d"};
        String[] resultList = {"1", "2", "3", "4"};

        Names names = new Names(Arrays.asList(nameList));
        Results results = new Results(Arrays.asList(resultList), 4);

        Ladder ladder = new Ladder();
        ladder.drawLine(4, count, new TrueGenerator());

        MatchingCalculator matchingCalculator = new MatchingCalculator(ladder, names, results);
        matchingCalculator.calculate().getMatchings().forEach((name, result) -> assertTrue(swap(name, result, count)));
    }

    private boolean swap(Name name, Result result, int count) {
        if (count % 2 == 1) {
            return swapOdd(name, result);
        }
        return swapEven(name, result);
    }

    private boolean swapOdd(Name name, Result result) {
        if (name.getName().equals("a")) {
            return result.getResult().equals("2");
        }
        if (name.getName().equals("b")) {
            return result.getResult().equals("1");
        }
        if (name.getName().equals("c")) {
            return result.getResult().equals("4");
        }
        if (name.getName().equals("d")) {
            return result.getResult().equals("3");
        }
        return false;
    }

    private boolean swapEven(Name name, Result result) {
        if (name.getName().equals("a")) {
            return result.getResult().equals("1");
        }
        if (name.getName().equals("b")) {
            return result.getResult().equals("2");
        }
        if (name.getName().equals("c")) {
            return result.getResult().equals("3");
        }
        if (name.getName().equals("d")) {
            return result.getResult().equals("4");
        }
        return false;
    }
}
