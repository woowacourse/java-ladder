package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesWithMatchedResultTest {
    @DisplayName("생성된다.")
    @Test
    void create() {
        PersonalName personalName = PersonalName.valueOf("name");
        LadderResultItem ladderResultItem = new LadderResultItem("item");
        assertDoesNotThrow(() -> new NamesWithMatchedResult(Map.of(personalName, ladderResultItem)));
    }

    @DisplayName("이름으로 결과를 검색할 수 있다.")
    @Test
    void queryByName() {
        //given
        PersonalName personalName1 = PersonalName.valueOf("hi");
        LadderResultItem ladderResultItem1 = new LadderResultItem("item1");
        PersonalName personalName2 = PersonalName.valueOf("bye");
        LadderResultItem ladderResultItem2 = new LadderResultItem("item2");
        NamesWithMatchedResult namesWithMatchedResult = new NamesWithMatchedResult(
                Map.of(personalName1, ladderResultItem1, personalName2, ladderResultItem2));
        //when
        LadderResultItem searchResult = namesWithMatchedResult.searchBy("hi");
        //then
        assertThat(searchResult).isEqualTo(ladderResultItem1);
    }
}