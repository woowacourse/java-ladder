package techcourse.jcf.mission;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

class SimpleArrayListTest {

    @Test
    void addStringTest() {
        final SimpleArrayList arrayList = new SimpleArrayList();

        arrayList.add("홍실");

        Assertions.assertThat(arrayList)
                .extracting("list")
                .asInstanceOf(InstanceOfAssertFactories.array(String[].class))
                .contains("홍실");
    }

    @Test
    void testAdd() {
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
