package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    @DisplayName("List에 String 값을 add한다.")
    void addStringTest() {
        final SimpleArrayList arrayList = new SimpleArrayList();

        arrayList.add("홍실");

        assertThat(arrayList).extracting("values")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("홍실");
    }

    @Test
    @DisplayName("List에 기본 사이즈에서 더 add해도 크기가 자동으로 늘어나는지 테스트")
    void addStringOverDefaultCapacity() {
        String[] array = {"홍실", "다니", "준팍", "에단", "로지", "애쉬", "디투", "블랙캣", "네오", "왼손"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        arrayList.add("져니");

        assertThat(arrayList).extracting("values")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("져니");
    }

    @Test
    @DisplayName("List안에 원하는 index에 값을 넣고, 기존에 있는 값을 한칸 뒤로 민다.")
    void addValueAtIndexTest() {
        String[] array = {"홍실", "다니", "준팍"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        arrayList.add(0, "썬샷");

        assertThat(arrayList).extracting("values")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("썬샷", atIndex(0))
                .contains("홍실", atIndex(1));
    }

    @Test
    @DisplayName("List안에 원하는 index에 값을 넣고, 이전에 있던 값을 반환받는다.")
    void setTest() {
        String[] array = {"홍실"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        final String setReturnValue = arrayList.set(0, "솔라");

        assertThat(setReturnValue).isEqualTo("홍실");
    }

    @Test
    @DisplayName("List안 원하는 index에 있는 값을 반환한다.")
    void getTest() {
        final String[] array = {"홍실"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        final String getValue = arrayList.get(0);

        assertThat(getValue)
                .isEqualTo("홍실");
    }

    @Test
    @DisplayName("contains 메서드는 해당 리스트안에 같은 값이 들어있는지 확인한다.")
    void contains() {
        final String[] array = {"홍실"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        Assertions.assertAll(
                () -> assertThat(arrayList.contains("홍실")).isTrue(),
                () -> assertThat(arrayList.contains("다니")).isFalse()
        );
    }

    @Test
    @DisplayName("리스트 안에 값이 있으면 값의 위치를 반환하고 없으면 -1을 반환한다.")
    void indexOf() {
        final String[] array = {"홍실", "다니"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        Assertions.assertAll(
                () -> assertThat(arrayList.indexOf("다니")).isEqualTo(1),
                () -> assertThat(arrayList.indexOf("썬샷")).isEqualTo(-1)
        );
    }

    @Test
    @DisplayName("size는 현재 리스트에 들어있는 값의 개수를 반환한다")
    void size() {
        final String[] array = {"홍실", "다니"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        assertThat(arrayList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("아무 값도 안들어 있으면 true를 반환한다")
    void isEmptyReturnTrueWhenListHasNotAnyValue() {
        final SimpleArrayList arrayList = new SimpleArrayList();

        assertThat(arrayList.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("값이 하나라도 들어있으면 false를 반환한다.")
    void isEmptyReturnFalseWhenListHasValue() {
        final String[] array = {"홍실"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        assertThat(arrayList.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("값을 넣어 있다면 삭제 후 true를 반환하고, 없다면 false를 반환한다.")
    void removeValueAndReturnBoolean() {
        final String[] array = {"홍실"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        final boolean isRemove = arrayList.remove("홍실");

        Assertions.assertAll(
                () -> assertThat(isRemove).isTrue(),
                () -> assertThat(arrayList)
                        .extracting("size")
                        .isEqualTo(0)
        );
    }

    @Test
    void removeValueAndReturn() {
        final String[] array = {"홍실", "다니"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        final String removedValue = arrayList.remove(0);

        Assertions.assertAll(
                () -> assertThat(removedValue).isEqualTo("홍실"),
                () -> assertThat(arrayList)
                        .extracting("size")
                        .isEqualTo(1)
        );
    }

    @Test
    @DisplayName("clear는 list안에 있는 값을 초기화 시킨다.")
    void clear() {
        final String[] array = {"홍실"};
        final SimpleArrayList arrayList = new SimpleArrayList(array);

        arrayList.clear();

        Assertions.assertAll(
                () -> assertThat(arrayList)
                        .extracting("size")
                        .isEqualTo(0),
                () -> assertThat(arrayList)
                        .extracting("values")
                        .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                        .containsExactly()
        );
    }
}
