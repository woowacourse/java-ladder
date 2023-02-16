package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Names 는")
class NamesTest {

    private final List<Name> nameList1 = List.of(new Name("일"), new Name("말랑"), new Name("둘리"));
    private final List<Name> nameList2 = List.of(new Name("말랑임"), new Name("말랑"), new Name("둘"));

    @Test
    void Name_List_를_통해_생성된다() {
        // when & then
        assertDoesNotThrow(() -> new Names(nameList1));
    }

    @Test
    void 첫_이름의_글자_수를_구할_수_있다() {
        // given
        Names names1 = new Names(nameList1);
        Names names2 = new Names(nameList2);

        // when
        int firstNameLength1 = names1.firstNameLength();
        int firstNameLength2 = names2.firstNameLength();

        // then
        assertThat(firstNameLength1).isEqualTo(1);
        assertThat(firstNameLength2).isEqualTo(3);
    }
}