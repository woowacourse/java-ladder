package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleLinkedListTest {

    @Test
    public void addToLastTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();

        //when
        String value = "test";
        values.add(value);

        //then
        assertThat(values.size()).isEqualTo(1);
    }

    @Test
    public void getTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String result = values.get(0);
        String result1 = values.get(1);

        //then
        assertThat(result).isEqualTo(first);
        assertThat(result1).isEqualTo(second);
    }

    @Test
    public void addToIndexBetweenTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String newValue = "newValue";
        values.add(1, newValue);

        //then
        assertThat(values.get(1)).isEqualTo(newValue);
    }

    @Test
    public void addToIndexFirstTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String newValue = "newValue";
        values.add(0, newValue);

        //then
        assertThat(values.get(0)).isEqualTo(newValue);
    }

    @Test
    public void addToIndexLastTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String newValue = "newValue";
        values.add(2, newValue);

        //then
        assertThat(values.get(2)).isEqualTo(newValue);
    }

    @Test
    public void setTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String newValue = "newValue";
        values.set(1, newValue);

        //then
        assertThat(values.get(1)).isEqualTo(newValue);
    }

    @Test
    public void containsTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        boolean result1 = values.contains("second");
        boolean result2 = values.contains("fail");

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @Test
    public void indexOfTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        int result1 = values.indexOf("second");
        int result2 = values.indexOf("fail");

        //then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(-1);
    }

    @Test
    public void isEmptyTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();

        //when
        boolean result = values.isEmpty();

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void clearTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        values.clear();

        //then
        assertThat(values.size()).isEqualTo(0);
    }

    @Test
    public void removeFirstByValueTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        values.add(first);

        //when
        boolean result = values.remove("first");

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void removeBetweenByValueTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        String third = "third";
        values.add(first);
        values.add(second);
        values.add(third);

        //when
        boolean result = values.remove("second");

        //then
        assertThat(result).isTrue();
        assertThat(values.get(1)).isEqualTo(third);
        assertThat(values.size()).isEqualTo(2);
    }

    @Test
    public void removeLastByValueTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        String third = "third";
        values.add(first);
        values.add(second);
        values.add(third);

        //when
        boolean result = values.remove("third");

        //then
        assertThat(result).isTrue();
        assertThat(values.get(1)).isEqualTo(second);
        assertThat(values.size()).isEqualTo(2);
    }

    @Test
    public void removeFirstByIndexTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        values.add(first);

        //when
        String result = values.remove(0);

        //then
        assertThat(result).isEqualTo(first);
    }

    @Test
    public void removeBetweenByIndexTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        String third = "third";
        values.add(first);
        values.add(second);
        values.add(third);

        //when
        String result = values.remove(1);

        //then
        assertThat(result).isEqualTo(second);
        assertThat(values.get(1)).isEqualTo(third);
        assertThat(values.size()).isEqualTo(2);
    }

    @Test
    public void removeLastByIndexTest() {
        //given
        SimpleLinkedList values = new SimpleLinkedList();
        String first = "first";
        String second = "second";
        String third = "third";
        values.add(first);
        values.add(second);
        values.add(third);

        //when
        String result = values.remove(2);

        //then
        assertThat(result).isEqualTo(result);
        assertThat(values.get(1)).isEqualTo(second);
        assertThat(values.size()).isEqualTo(2);
    }
}
