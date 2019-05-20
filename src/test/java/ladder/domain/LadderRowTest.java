package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderRowTest {

    @Test
    public void 사다리_한줄_긋기_1칸남음() {

        for (int i = 0; i < 1000; i++) {
            assertEquals(Arrays.asList(LadderLineTest.line(0)), LadderRowGenerator.row(1).status());
        }
    }

    @Test
    public void 사다리_만들기_테스트() {
        assertEquals(Arrays.asList(LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(0)),

                LadderRowGenerator.row(Arrays.asList(LadderLineTest.line(1),
                        LadderLineTest.line(-1), LadderLineTest.line(1),
                        LadderLineTest.line(-1), LadderLineTest.line(0))).status());
    }
}
