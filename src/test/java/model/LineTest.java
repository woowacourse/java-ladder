package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Connection;
import util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("Line 객체 생성 성공 테스트")
    void createLineTest(){
        Assertions.assertThatNoException().isThrownBy(()->{new Line(5);});
    }

    @ParameterizedTest(name = "라인 랜덤 생성 성공 테스트 inputType={0}")
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    void createLineRandomTest(int input, boolean result){
        List<Integer> randomLine = new ArrayList<>(Arrays.asList(input));
        TestLineGenerator testlineGenerator = new TestLineGenerator(randomLine);

        assertThat(Connection.valueOf(testlineGenerator.generate()).getStatus()).isEqualTo(result);
    }

    static class TestLineGenerator implements Generator {
        private final List<Integer> lines;

        public TestLineGenerator(List<Integer> lines) {
            this.lines = lines;
        }

        @Override
        public int generate() {
            return lines.remove(0);
        }
    }
}
