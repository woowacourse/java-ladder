package ladder.domain;

import static org.testng.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.util.TrueGenerator;

class MatchingCalculatorTest {
    private Names names;
    private Results results;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        String[] nameList = {"a", "b", "c", "d"};
        String[] resultList = {"1", "2", "3", "4"};
        names = new Names(Arrays.asList(nameList));
        results = new Results(Arrays.asList(resultList), 4);
        ladder = new Ladder();
    }

    @Test
    @DisplayName("참여자와 실행 결과를 매칭한다. - 사다리 높이 1")
    void matchingCalculatorTest1() {
        ladder.drawLine(4, 1, new TrueGenerator());
        MatchingCalculator matchingCalculator = new MatchingCalculator(ladder, names, results);
        matchingCalculator.calculate().getMatchings().forEach((name, result) -> assertTrue(swapOdd(name, result)));
    }

    @Test
    @DisplayName("참여자와 실행 결과를 매칭한다. - 사다리 높이 2")
    void matchingCalculatorTest2() {
        ladder.drawLine(4, 2, new TrueGenerator());
        MatchingCalculator matchingCalculator = new MatchingCalculator(ladder, names, results);
        matchingCalculator.calculate().getMatchings().forEach((name, result) -> assertTrue(swapEven(name, result)));
    }

    @Test
    @DisplayName("참여자와 실행 결과를 매칭한다. - 사다리 높이 3")
    void matchingCalculatorTest3() {
        ladder.drawLine(4, 3, new TrueGenerator());
        MatchingCalculator matchingCalculator = new MatchingCalculator(ladder, names, results);
        matchingCalculator.calculate().getMatchings().forEach((name, result) -> assertTrue(swapOdd(name, result)));
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
