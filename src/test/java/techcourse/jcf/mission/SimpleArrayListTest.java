package techcourse.jcf.mission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {
    @DisplayName("SimpleArrayList 생성 테스트")
    @Test
    void SimpleArrayList_생성_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new SimpleArrayList();
        });
    }

    @DisplayName("SimpleArrayList 원소 추가 테스트")
    @Test
    void SimpleArrayList_원소_추가_테스트() {
        Assertions.assertEquals(true, new SimpleArrayList().add("hello"));
    }

    @DisplayName("SimpleArrayList 특정 인덱스에 원소 추가 테스트")
    @Test
    void SimpleArrayList_특정_인덱스에_원소_추가_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new SimpleArrayList().add(0, "hello");
        });
    }

    @DisplayName("SimpleArrayList 범위를 벗어나는 특정 인덱스에 원소 추가 실패 테스트")
    @Test
    void SimpleArrayList_잘못된_범위의_특정_인덱스에_원소_추가_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SimpleArrayList().add(1, "hello");
                });
    }
}
