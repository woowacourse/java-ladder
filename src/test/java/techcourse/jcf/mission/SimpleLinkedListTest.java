package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleLinkedListTest {

    @Test
    public void addTest() {
        SimpleLinkedList myValues = new SimpleLinkedList();

        Assertions.assertThat(myValues.add("first")).isTrue();
        Assertions.assertThat(myValues.add("second")).isTrue();
    }

    @Test
    public void getTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        SimpleLinkedList myValues = new SimpleLinkedList();
        for (String value : values) {
            myValues.add(value);
        }

        assertThat(myValues.get(10)).isEqualTo("k");
        Assertions.assertThatThrownBy(() -> myValues.get(11))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void isEmptyTest() {
        SimpleLinkedList myValues = new SimpleLinkedList();
        assertThat(myValues.isEmpty()).isTrue();

        myValues.add("a");
        assertThat(myValues.isEmpty()).isFalse();
    }

    @Test
    public void containsTest() {
        String input = "hi hi";
        SimpleLinkedList myValues = new SimpleLinkedList();

        assertThat(myValues.contains(input)).isFalse();

        myValues.add(input);
        assertThat(myValues.contains(input)).isTrue();
    }

    @Test
    public void indexOfTest() {
        SimpleLinkedList myValues = new SimpleLinkedList();

        myValues.add("first");
        myValues.add("first");
        myValues.add("third");

        assertThat(myValues.indexOf("first")).isEqualTo(0);
        assertThat(myValues.indexOf("third")).isEqualTo(2);
        assertThat(myValues.indexOf("이건없지롱")).isEqualTo(-1);
    }

}
