import domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class PlayerTest {
    @DisplayName("생성자 테스트")
    @Test
    void create() {
        new Players(List.of("pobi", "beaver", "jena"));
    }

    @Nested
    @DisplayName("플레이어 이름 길이 테스트")
    class nameLength {
        @DisplayName("사용자의 이름의 길이가 5초과 일때 에러 확인")
        @Test
        void namelength1() {
            Assertions.assertThatThrownBy(() -> new Players(List.of("pobiss", "crong")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자 이름의 길이가 0 일때 에러 확인")
        @Test
        void namelength2() {
            Assertions.assertThatThrownBy(() -> new Players(List.of("pobi", "", "crong")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자 이름이 공백 일때 에러 확인")
        @Test
        void namelength3() {
            Assertions.assertThatThrownBy(() -> new Players(List.of("pobi", "      ", "crong")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("플레이어 인원수 테스트")
    class playerCount {
        @DisplayName("플레이어가 1명일때 실패")
        @Test
        void playerCount1() {
            assertThatThrownBy(() -> {
                new Players(List.of("a"));
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("플레이어가 2명일때 성공")
        @Test
        void playerCount2() {
            assertThatNoException().isThrownBy(() -> {
                new Players(List.of("a", "b"));
            });
        }

        @DisplayName("플레이어가 12명일때 성공")
        @Test
        void playerCount3() {
            assertThatNoException().isThrownBy(() -> {
                new Players(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"));
            });
        }

        @DisplayName("플레이어가 13명일때 실패")
        @Test
        void playerCount4() {
            assertThatThrownBy(() -> {
                new Players(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n"));
            }).isInstanceOf(IllegalArgumentException.class);
        }

    }

    @DisplayName("플레이어 이름이 중복될 때")
    @Test
    void duplicateName() {
        assertThatThrownBy(() -> {
            new Players(List.of("aaaa", "aaaa"));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름의 최대길이 구하기")
    @Test
    void maxName() {
        Players players = new Players(List.of("aaa", "bbbb"));
        assertThat(players.getMaxPlayerNameLength()).isEqualTo(4);
    }
}
