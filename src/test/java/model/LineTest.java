package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Generator generator;
    @Test
    @DisplayName("Line 객체 생성 성공 테스트")
    void createLineTest(){
        List<Boolean> randomLine = new ArrayList<>(Arrays.asList(false,true));
        generator = new TestLineGenerator(randomLine);
        Assertions.assertThatNoException().isThrownBy(()->{new Line(2,generator);});
    }

    @ParameterizedTest(name = "라인 랜덤 생성 성공 테스트 inputType={0}")
    @CsvSource(value = {"false:false", "true:true"}, delimiter = ':')
    void createLineRandomTest(boolean input, boolean result){
        List<Boolean> randomLine = new ArrayList<>(Arrays.asList(input));
        generator = new TestLineGenerator(randomLine);

        assertThat(generator.generate()).isEqualTo(result);
    }

    static class TestLineGenerator implements Generator {
        private final List<Boolean> lines;

        public TestLineGenerator(List<Boolean> lines) {
            this.lines = lines;
        }

        @Override
        public boolean generate() {
            return lines.remove(0);
        }
    }
}
