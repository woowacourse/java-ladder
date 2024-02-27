package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RungsTest {
    @Nested
    @DisplayName("인덱스가 ")
    class findConnectedIndexTest {
        @Test
        @DisplayName("범위 내에 있으면 연결된 인덱스를 찾는다.")
        void findConnectedIndexWhenIndexIsInRange() {
            Rungs rungs = new Rungs(List.of(Rung.of(true)));

            assertThat(rungs.findConnectedIndex(0)).isEqualTo(1);
        }

        @Test
        @DisplayName("범위보다 작으면 최소 인덱스로 설정 후 연결된 인덱스를 찾는다.")
        void findConnectedIndexWhenIndexIsMinimum() {
            Rungs rungs = new Rungs(List.of(Rung.of(true)));

            assertThat(rungs.findConnectedIndex(-1)).isEqualTo(1);
        }

        @Test
        @DisplayName("범위보다 크면 최대 인덱스로 설정 후 연결된 인덱스를 찾는다.")
        void findConnectedIndexWhenIndexIsMaximum() {
            Rungs rungs = new Rungs(List.of(Rung.of(true)));

            assertThat(rungs.findConnectedIndex(2)).isEqualTo(0);
        }
    }
}
