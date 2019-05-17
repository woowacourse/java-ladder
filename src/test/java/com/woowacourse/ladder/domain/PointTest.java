package com.woowacourse.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {
    Point point;


    @Test
    void point가0미만일때_익셉션을_던지는지() {
       assertThatIllegalArgumentException().isThrownBy(() ->{
           new Point(-1,100);
       });
    }

    @Test
    void point의최대값이상일때_익셉션을_던지는지() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Point(0,10001);
        });
    }

    @Test
    void point의위치가_최대값을넘길때_익셉션을_던지는지() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Point(1001,1000);
        });
    }

}
