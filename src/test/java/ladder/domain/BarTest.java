package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BarTest {
    
    @Test
    void valueOfBarTrue() {
        Bar bar = Bar.valueOfBar(true);
        assertThat(bar).isEqualTo(Bar.TRUE);
    }
    
    @Test
    void valueOfBarFalse() {
        Bar bar = Bar.valueOfBar(false);
        assertThat(bar).isEqualTo(Bar.FALSE);
    }
    
    @Test
    void trueBar() {
        assertThat(Bar.TRUE.isExistBar()).isTrue();
    }
    
    @Test
    void falseBar() {
        assertThat(Bar.FALSE.isExistBar()).isFalse();
    }
}