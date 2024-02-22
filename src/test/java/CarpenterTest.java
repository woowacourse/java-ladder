import domain.*;
import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarpenterTest {

    @Test
    @DisplayName("높이와 참가자수, 번호생성기가 주어지면 높이만큼 사다리를 생성한다.")
    void makeLadder() {
        // given
        final Carpenter carpenter = Carpenter.of(new Height(4), PlayerCount.from(3));

        // when & then
        assertThat(carpenter.makeLadder()).extracting("lines")
                .asList()
                .hasSize(4);
    }
}
