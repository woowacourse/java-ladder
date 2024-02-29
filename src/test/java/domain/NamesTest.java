package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이름 일급 컬렉션 테스트")
class NamesTest {

    @DisplayName("이름이 중복될 경우 생성 검증에 실패한다")
    @Test
    void testCreateWithDuplicatedNames() {
        List<PlayerName> playerNames = List.of(new PlayerName("리비"), new PlayerName("리비"), new PlayerName("잉크"));
        assertThatThrownBy(() -> new Names(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복될 수 없습니다");
    }

    @DisplayName("이름이 주어지면 인덱스를 계산할 수 있다")
    @Test
    void testIndexOf() {
        Names names = new Names(List.of(new PlayerName("리비"), new PlayerName("테니"), new PlayerName("잉크")));
        assertThat(names.indexOf("리비")).isEqualTo(0);
    }

    @DisplayName("주어진 이름이 존재하지 않으면 예외를 발생시킨다")
    @Test
    void testNotExistName() {
        Names names = new Names(List.of(new PlayerName("리비"), new PlayerName("제리"), new PlayerName("잉크")));
        assertThatThrownBy(() -> names.indexOf("리베르"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 해당하는 이름을 찾을 수 없습니다");
    }

    @DisplayName("이름이 중복되지 않을 경우 생성 검증에 성공한다")
    @Test
    void testCreateWithUniqueNames() {
        List<PlayerName> playerNames = List.of(new PlayerName("리비"), new PlayerName("테니"), new PlayerName("잉크"));
        assertThatCode(() -> new Names(playerNames)).doesNotThrowAnyException();
    }

    @DisplayName("참여 인원 2명 이상이 아니면 생성 검증에 실패한다.")
    @Test
    void testCreateWithNotEnoughEntry() {
        List<PlayerName> playerNames = List.of(new PlayerName("리비"));
        assertThatThrownBy(() -> new Names(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여 인원은 2명 이상이어야 합니다");
    }

    @DisplayName("참여 인원이 2명 이상이면 생성 검증에 성공한다 ")
    @Test
    void testCreateWithEnoughEntry() {
        List<PlayerName> playerNames = List.of(new PlayerName("리비"), new PlayerName("잉크"));
        assertThatCode(() -> new Names(playerNames)).doesNotThrowAnyException();
    }
}
