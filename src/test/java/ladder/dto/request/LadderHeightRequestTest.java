package ladder.dto.request;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.ladder.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightRequestTest {
    @DisplayName("객체로 변환한다.")
    @Test
    void testToHeight() {
        LadderHeightRequest ladderHeightRequest = new LadderHeightRequest("5");

        assertThat(ladderHeightRequest.toHeight()).isEqualTo(new LadderHeight(5));
    }
}
