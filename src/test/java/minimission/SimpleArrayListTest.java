package minimission;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    private SimpleList simpleList = new SimpleArrayList();

    @BeforeEach
    void setUp() {
        simpleList = new SimpleArrayList();
    }

    @Test
    void addTest() {
        simpleList.add("1");
        simpleList.add("3");
        simpleList.add(0, "0");
        simpleList.add(2, "2");

        assertThat(simpleList.toString()).isEqualTo("0,1,2,3");
    }

    @Test
    void setTest() {
        simpleList.add("1");
        simpleList.add("2");
        simpleList.set(0, "3");
        simpleList.set(1, "4");

        assertThat(simpleList.toString()).isEqualTo("3,4");
    }

    @Test
    void getTest() {
        simpleList.add("1");
        simpleList.add("2");

        assertThat(simpleList.get(0)).isEqualTo("1");
        assertThat(simpleList.get(1)).isEqualTo("2");
    }

    @Test
    void containsTest() {
        simpleList.add("1");

        assertThat(simpleList.contains("1")).isTrue();
        assertThat(simpleList.contains("2")).isFalse();
    }

    @Test
    void indexOfTest() {
        simpleList.add("1");
        simpleList.add("2");

        assertThat(simpleList.indexOf("1")).isEqualTo(0);
        assertThat(simpleList.indexOf("2")).isEqualTo(1);
    }

    @Test
    void removeTest() {
        simpleList.add("1");
        simpleList.add("2");
        simpleList.remove(0);
        simpleList.remove("2");

        assertThat(simpleList.toString()).isEqualTo("");
    }

    @Test
    void isEmptyTest() {
        assertThat(simpleList.isEmpty()).isTrue();
    }

    @Test
    void clearTest() {
        simpleList.add("1");
        simpleList.clear();

        assertThat(simpleList.toString()).isEqualTo("");
    }
}
