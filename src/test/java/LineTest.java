import domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("라인을 생성한다.")
    void createLine() {
        assertThatCode(() -> new Line()).doesNotThrowAnyException();
    }
    
    @Test
    @DisplayName("가로 길이는 사용자 수 -1 이다.")
    void methodName() throws Exception {
        //given
        int personCount = 4;
        //when
        //then
        assertThatCode(() -> new Line(personCount)).doesNotThrowAnyException();
    }
    

}
