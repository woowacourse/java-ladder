package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(arrayList).extracting("list")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("홍실");
    }

    //ArrayList의 rangeCheckForAdd 확인하기.
    @Test
    @DisplayName("List안에 원하는 index에 값을 add한다.")
    void addValueAtIndexTest() {
        final SimpleArrayList arrayList = new SimpleArrayList();

        arrayList.add(0, "홍실");

        assertThat(arrayList).extracting("list")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class));
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
    void indexOf() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }
}
