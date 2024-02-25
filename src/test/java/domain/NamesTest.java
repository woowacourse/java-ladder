package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("이름 일급 컬렉션 테스트")
class NamesTest {

    @DisplayName("이름이 중복될 경우 생성 검증에 실패한다")
    @Test
    void testCreateWithDuplicatedNames() {
        List<Name> names = List.of(new Name("리비"), new Name("리비"), new Name("잉크"));
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 중복될 수 없습니다");
    }

    @DisplayName("이름이 중복되지 않을 경우 생성 검증에 성공한다")
    @Test
    void testCreateWithUniqueNames() {
        List<Name> names = List.of(new Name("리비"), new Name("테니"), new Name("잉크"));
        Assertions.assertThatCode(() -> new Names(names)).doesNotThrowAnyException();
    }

    @DisplayName("참여 인원 2명 이상이 아니면 생성 검증에 실패한다.")
    @Test
    void testCreateWithNotEnoughEntry() {
        List<Name> names = List.of(new Name("리비"));
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 참여 인원은 2명 이상이어야 합니다");
    }

    @DisplayName("참여 인원이 2명 이상이면 생성 검증에 성공한다 ")
    @Test
    void testCreateWithEnoughEntry() {
        List<Name> names = List.of(new Name("리비"), new Name("잉크"));
        Assertions.assertThatCode(() -> new Names(names)).doesNotThrowAnyException();
    }
}
