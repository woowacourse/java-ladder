import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {
    @DisplayName("생성자 테스트")
    @Test
    void create() {
        new Players(List.of("pobi", "beaver", "jena"));
    }

    /*@DisplayName("사용자의 이름의 길이가 5초과 일때 에러 확인")
    @Test
    void create() {
        new Players(List.of("pobiss"));
    }*/

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
                new Players(List.of("a","b"));
            });
        }

        @DisplayName("플레이어가 12명일때 성공")
        @Test
        void playerCount3() {
            assertThatNoException().isThrownBy(() -> {
                new Players(List.of("a","b","c","d","e","f","g","h","i","j","k","l"));
            });
        }

        @DisplayName("플레이어가 13명일때 실패")
        @Test
        void playerCount4() {
            assertThatThrownBy(() -> {
                new Players(List.of("a","b","c","d","e","f","g","h","i","j","k","l","n"));
            }).isInstanceOf(IllegalArgumentException.class);
        }

    }
    //사용자의 이름이 중복
    //입력값이 없을때

}
