package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    public void addWithIndexTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        SimpleLinkedList myValues = new SimpleLinkedList();
        for (String value : values) {
            Assertions.assertThat(myValues.add(value)).isTrue();
        }

        String newValue = "함정카드";
        String oldValue = myValues.get(0);

        myValues.add(0, newValue);
        assertThat(myValues.size()).isEqualTo(12);
        assertThat(myValues.get(0)).isEqualTo(newValue);
        assertThat(myValues.get(1)).isEqualTo(oldValue);

        myValues.add(12, newValue);
        assertThat(myValues.size()).isEqualTo(13);
        assertThat(myValues.get(12)).isEqualTo(newValue);

        Assertions.assertThatThrownBy(() -> myValues.add(14, "이건 못넣지"))
                .isInstanceOf(IndexOutOfBoundsException.class);
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

    @Test
    public void setTest() {
        SimpleLinkedList myValues = new SimpleLinkedList();

        Assertions.assertThatThrownBy(() -> myValues.set(0, "hi hi"))
                .isInstanceOf(IndexOutOfBoundsException.class);

        myValues.add("hi hi 2");

        assertThat(myValues.set(0, "hi hi 3")).isEqualTo("hi hi 2");
        assertThat(myValues.get(0)).isEqualTo("hi hi 3");

        myValues.add("hi hi 4");
        myValues.add("hi hi 5");
        myValues.add("hi hi 6");
        myValues.add("hi hi 7");

        assertThat(myValues.set(4, "hi hi 8")).isEqualTo("hi hi 7");
        assertThat(myValues.get(4)).isEqualTo("hi hi 8");

        assertThat(myValues.set(0, "hi hi 9")).isEqualTo("hi hi 3");
        assertThat(myValues.get(0)).isEqualTo("hi hi 9");

        Assertions.assertThatThrownBy(() -> myValues.set(5, "인덱스 에러가 나겠지"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void removeWithIndexTest() {
        SimpleLinkedList myValues = new SimpleLinkedList();

        myValues.add("first");
        myValues.add("second");
        myValues.add("third");

        assertThat(myValues.remove(1)).isEqualTo("second");
        assertThat(myValues.get(1)).isEqualTo("third");
        assertThat(myValues.size()).isEqualTo(2);
        assertThat(myValues.contains("second")).isFalse();

        assertThat(myValues.remove(1)).isEqualTo("third");
        assertThat(myValues.remove(0)).isEqualTo("first");
        assertThat(myValues.isEmpty()).isTrue();

        Assertions.assertThatThrownBy(() -> myValues.remove(5))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}
