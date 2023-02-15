package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@DisplayName("이름들은 ")
class NamesTest {
    @Nested
    @DisplayName("중복된 사람이 ")
    class DuplicatedCase {
        @Test
        @DisplayName("없을 경우 정상적으로 객체 생성")
        void whenNoDuplicatedNames() {
            assertThatCode(() -> new Names(List.of("pobi", "crong")))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("있을 경우 익셉션 발생")
        void whenDuplicatedNames() {
            assertThatThrownBy(() -> new Names(List.of("pobi", "pobi")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 사람은 참여할 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("명 수가 ")
    class SizeCase{

        @Test
        @DisplayName(" 1명이면 익셉션이 발생한다.")
        void whenOnlyOnePerson(){
            assertThatThrownBy(()-> new Names(List.of("pobi")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 2명이상 참가자가 필요합니다.");
        }

        @Test
        @DisplayName(" 2명이면 성공적으로 생성된다.")
        void whenOverTwoPerson(){
            assertThatCode(()-> new Names(List.of("pobi", "honux")))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName(" 10명이면 성공적으로 생성된다.")
        void whenUnderTenPerson(){
            assertThatCode(() -> new Names(List.of("a","b","c","d","e","f","g","h", "i", "j")))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName(" 11명 이상이면 익셉션이 발생한다.")
        void whenOverElevenPerson(){
            assertThatThrownBy(()-> new Names(List.of("a","b","c","d","e","f","g","h", "i", "j", "k")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최대 10명 이하 참가자가 필요합니다.");
        }
    }
}