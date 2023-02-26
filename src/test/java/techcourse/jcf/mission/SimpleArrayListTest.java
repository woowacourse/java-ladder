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

    @DisplayName("SimpleArrayList 범위 내부의 원소 설정 테스트")
    @Test
    void SimpleArrayList_범위_내부의_원소_재설정_테스트() {
        SimpleArrayList arrayList = new SimpleArrayList();
        final String beforeValue = "before";
        final String setValue = "after";
        arrayList.add(beforeValue);

        Assertions.assertEquals(beforeValue, arrayList.set(0, setValue));
    }

    @DisplayName("SimpleArrayList 범위를 벗어나는 특정 인덱스의 원소 재설정 실패 테스트")
    @Test
    void SimpleArrayList_잘못된_범위_인덱스의_원소_설정_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SimpleArrayList().set(1, "hello");
                });
    }

    @DisplayName("SimpleArrayList 범위 내부의 원소 반환 테스트")
    @Test
    void SimpleArrayList_범위_내부의_원소_반환_테스트() {
        SimpleArrayList arrayList = new SimpleArrayList();
        final String beforeValue = "before";
        arrayList.add(beforeValue);

        Assertions.assertEquals(beforeValue, arrayList.get(0));
    }

    @DisplayName("SimpleArrayList 범위를 벗어나는 특정 인덱스의 원소 반환 실패 테스트")
    @Test
    void SimpleArrayList_잘못된_범위_인덱스의_원소_반환_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SimpleArrayList().get(1);
                });
    }
}
