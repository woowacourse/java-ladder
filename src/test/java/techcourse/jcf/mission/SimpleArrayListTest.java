package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    @DisplayName("List에 String 값을 add한다.")
    void addStringTest() {
        final SimpleArrayList arrayList = new SimpleArrayList();

        arrayList.add("홍실");

        assertThat(arrayList)
                .extracting("list")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("홍실");
    }

    //ArrayList의 rangeCheckForAdd 확인하기.
    @Test
    @DisplayName("List안에 원하는 index에 값을 add한다.")
    void addValueAtIndexTest() {
        final SimpleArrayList arrayList = new SimpleArrayList(4);

        arrayList.add(0, "홍실");

        assertThat(arrayList)
                .extracting("list")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("홍실");
    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
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
