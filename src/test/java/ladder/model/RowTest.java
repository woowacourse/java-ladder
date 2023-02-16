package ladder.model;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class RowTest {


    @Test
    @DisplayName("특정 포인트에 가로 라인 생성 테스트")
    void createLineTest() {
        int personCount = 5;
        List<Boolean> test = newArrayList(true, false, false, true);
        Row row = new Row(personCount, new TestLineCreateDecider(test));
        Assertions.assertThat(row.getPoints()).containsExactly(true, false, false, true);
    }

    @Test
    @DisplayName("왼쪽 포인트에 이미 라인이 존재하는 경우 가로 라인 생성 안됨 테스트")
    void createLineIfLeftHasLineTest() {
        int personCount = 5;
        List<Boolean> test = newArrayList(true, true, false, true);
        Row row = new Row(personCount, new TestLineCreateDecider(test));
        Assertions.assertThat(row.getPoints()).containsExactly(true, false, false, true);
    }




    static class TestLineCreateDecider implements LineCreateDecider {

        private final List<Boolean> isCreated;

        TestLineCreateDecider(List<Boolean> isCreated) {
            this.isCreated = isCreated;
        }

        @Override
        public boolean decide() {
            return isCreated.remove(0);
        }

    }


}