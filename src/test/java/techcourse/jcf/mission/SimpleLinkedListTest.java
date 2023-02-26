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

    @DisplayName("SimpleLinkedList 범위 내부의 원소 설정 테스트")
    @Test
    void SimpleLinkedList_범위_내부의_원소_재설정_테스트() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        final String beforeValue = "before";
        final String setValue = "after";
        linkedList.add(beforeValue);

        Assertions.assertEquals(beforeValue, linkedList.set(0, setValue));
    }

    @DisplayName("SimpleLinkedList 범위를 벗어나는 특정 인덱스의 원소 재설정 실패 테스트")
    @Test
    void SimpleLinkedList_잘못된_범위_인덱스의_원소_설정_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SimpleLinkedList().set(1, "hello");
                });
    }

    @DisplayName("SimpleLinkedList 범위 내부의 원소 반환 테스트")
    @Test
    void SimpleLinkedList_범위_내부의_원소_반환_테스트() {
        SimpleLinkedList linkedList = new SimpleLinkedList();
        final String beforeValue = "before";
        linkedList.add(beforeValue);

        Assertions.assertEquals(beforeValue, linkedList.get(0));
    }

    @DisplayName("SimpleLinkedList 범위를 벗어나는 특정 인덱스의 원소 반환 실패 테스트")
    @Test
    void SimpleLinkedList_잘못된_범위_인덱스의_원소_반환_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SimpleLinkedList().get(1);
                });
    }
}
