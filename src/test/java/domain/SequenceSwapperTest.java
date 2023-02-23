package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SequenceSwapperTest {
    @Test
    @DisplayName("순서 변환 객체는 순서를 가지고 있다.")
    void makeValidSequenceTest(){
        SequenceSwapper swapper = SequenceSwapper.of([0,1,2,3]);
        assertThat(swapper.getSequence()).isContainsExactly([0,1,2,3]);
