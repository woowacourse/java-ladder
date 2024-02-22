import domain.Carpenter;
import domain.Height;
import domain.PlayerCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarpenterTest {

    @Test
    @DisplayName("높이와 참가자수, 번호생성기가 주어지면 번호에 따른 랜덤 사다리를 생성한다.")
    void makeLadder() {
        final Carpenter carpenter = Carpenter.of(new Height(4), PlayerCount.from(3));

        assertThat(carpenter.makeLadder()).extracting("lines")
                .asList()
                .hasSize(4);
    }
}
