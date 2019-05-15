package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 라인생성 (){
        int height = 5;
        assertThat(new Line(height).getLength()).isEqualTo(5);
    }
}
