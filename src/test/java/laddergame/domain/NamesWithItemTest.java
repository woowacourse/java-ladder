package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;
import laddergame.domain.game.NamesWithItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesWithItemTest {
    @DisplayName("생성된다.")
    @Test
    void create() {
        PersonalName personalName = PersonalName.valueOf("name");
        LadderResultItem ladderResultItem = new LadderResultItem("item");
        assertDoesNotThrow(() -> new NamesWithItem(Map.of(personalName, ladderResultItem)));
    }

    @DisplayName("이름으로 결과를 검색할 수 있다.")
    @Test
    void queryByName() {
        //given
        PersonalName personalName1 = PersonalName.valueOf("hi");
        LadderResultItem ladderResultItem1 = new LadderResultItem("item1");
        PersonalName personalName2 = PersonalName.valueOf("bye");
        LadderResultItem ladderResultItem2 = new LadderResultItem("item2");
        NamesWithItem namesWithItem = new NamesWithItem(
                Map.of(personalName1, ladderResultItem1, personalName2, ladderResultItem2));
        //when
        LadderResultItem searchResult = namesWithItem.searchBy("hi");
        //then
        assertThat(searchResult).isEqualTo(ladderResultItem1);
    }

    @DisplayName("이름이 존재하지 않으면 예외가 발생한다.")
    @Test
    void throwExceptionWhenNameNotFound() {
        //given
        NamesWithItem namesWithItem = new NamesWithItem(Map.of());
        //when
        //then
        Assertions.assertThatThrownBy(() -> namesWithItem.searchBy("no"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 결과를 반환하는 메서드")
    @Test
    void getNameToItem() {
        //given
        NamesWithItem namesWithItem = new NamesWithItem(
                Map.of(PersonalName.valueOf("first"), new LadderResultItem("item1"),
                        PersonalName.valueOf("second"), new LadderResultItem("item2"))
        );

        Map<PersonalName, LadderResultItem> nameToItem = namesWithItem.getNameToItem();
        assertThat(nameToItem.keySet()).contains(PersonalName.valueOf("first"), PersonalName.valueOf("second"));
    }

//    @DisplayName("반환된 결과는 수정할 수 없다.")
}