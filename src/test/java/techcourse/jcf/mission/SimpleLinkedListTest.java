package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleLinkedListTest {
    @DisplayName("SimpleLinkedList 생성 테스트")
    @Test
    void SimpleLinkedList_생성_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new SimpleLinkedList();
        });
    }

    @DisplayName("SimpleLinkedList 원소 추가 테스트")
    @Test
    void SimpleLinkedList_원소_추가_테스트() {
        Assertions.assertEquals(true, new SimpleLinkedList().add("hello"));
    }

    @DisplayName("SimpleLinkedList 특정 인덱스에 원소 추가 테스트")
    @Test
    void SimpleLinkedList_특정_인덱스에_원소_추가_테스트() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        Assertions.assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) {
                linkedList.add(i, "a");
            }
        });
    }

}
