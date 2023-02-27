package techcourse.jcf.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleLinkedListTest {

    @Test
    void SimpleLinkedList_test() {
        SimpleArrayList values = new SimpleArrayList();
        values.add("first");    // {"first"}
        values.add("second");   // {"first", "second"}
        assertThat(values.add("third")).isTrue();   // {"first", "second", "third"}
        values.add("fourth");   // {"first", "second", "third", "fourth"}
        values.add("fifth");    // {"first", "second", "third", "fourth", "fifth"}
        values.add("sixth");    // {"first", "second", "third", "fourth", "fifth", "sixth"}
        assertThat(values.size()).isEqualTo(6);

        values.add(3, "4");     // // {"first", "second", "third", "4", "fourth", "fifth", "sixth"}
        assertThat(values.get(3)).isEqualTo("4");
        assertThat(values.get(6)).isEqualTo("sixth");
        assertThat(values.size()).isEqualTo(7);

        assertThat(values.remove(3)).isEqualTo("4");   // {"first", "second", "third", "fourth", "fifth", "sixth"}
        assertThat(values.get(3)).isEqualTo("fourth");
        assertThat(values.get(5)).isEqualTo("sixth");
        assertThat(values.size()).isEqualTo(6);

        values.add(8, "ninth");     // {"first", "second", "third", "fourth", "fifth", "sixth", null, null, "ninth"}
        assertThat(values.get(6)).isEqualTo(null);
        assertThat(values.get(7)).isEqualTo(null);
        assertThat(values.get(8)).isEqualTo("ninth");
        assertThat(values.size()).isEqualTo(9);

        assertThat(values.set(4, "555")).isEqualTo("fifth");    // {"first", "second", "third", "fourth", "555", "sixth", null, null, "ninth"}
        assertThat(values.get(4)).isEqualTo("555");

        assertThat(values.contains("555")).isTrue();
        assertThat(values.contains("nonono")).isFalse();

        assertThat(values.indexOf("555")).isEqualTo(4);
        assertThat(values.indexOf("nonono")).isEqualTo(-1);

        assertThat(values.remove("555")).isTrue();      // / {"first", "second", "third", "fourth", "sixth", null, null, "ninth"}
        assertThat(values.get(4)).isEqualTo("sixth");
        assertThat(values.remove("nonono")).isFalse();
        assertThat(values.size()).isEqualTo(8);

        assertThat(values.isEmpty()).isFalse();
        values.clear();     // {}
        assertThat(values.isEmpty()).isTrue();
        assertThat(values.size()).isEqualTo(0);
    }
}