package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowTest {

    @DisplayName("행 내부의 라인이 겹치지 않도록 생성할 수 있다.")
    @Test
    void makeNotDuplicateInLine() {
        LadderRow ladderRow = new LadderRow(new ArrayList<>(List.of(true, true, true, true)));
        assertThat(ladderRow.getLineStatus()).isEqualTo(List.of(true, false, true, false));
    }


}
