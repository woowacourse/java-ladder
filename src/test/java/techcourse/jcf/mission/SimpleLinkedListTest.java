package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleLinkedListTest {
    @DisplayName("SimpleLinkedList 생성 테스트")
    @Test
    void SimpleLinkedList_생성_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new SimpleLinkedList();
        });
    }



}
