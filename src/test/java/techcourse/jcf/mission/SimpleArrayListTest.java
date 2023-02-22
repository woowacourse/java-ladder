package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleArrayListTest {

    @Test
    public void sizeSuccess() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String data = "data";

        //when
        values.add(data);

        //then
        assertThat(values.size()).isEqualTo(1);
    }

    @Test
    public void addTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String data = "data";

        //when
        values.add(data);

        //then
        assertThat(values.size()).isEqualTo(1);
    }

    @Test
    public void getTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String data = "data";
        values.add(data);

        //when
        String result = values.get(0);

        //then
        assertThat(result).isEqualTo(data);
    }

    @Test
    public void addToIndexTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        values.add(first);

        //when
        String second = "second";
        values.add(1, second);

        //then
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.get(1)).isEqualTo(second);
    }

    @Test
    public void setTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);
        String newData = "newData";

        //when
        values.set(1, newData);

        //then
        assertThat(values.get(1)).isEqualTo(newData);
    }

    @Test
    public void containsTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String successValue = "first";
        String failValue = "fail";
        boolean success = values.contains(successValue);
        boolean fail = values.contains(failValue);

        //then
        assertThat(success).isTrue();
        assertThat(fail).isFalse();
    }

    @Test
    public void indexOfTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String target = "first";
        int result = values.indexOf(target);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void isEmptyTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();

        //when
        boolean result = values.isEmpty();

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void removeFromValueTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        boolean result = values.remove("first");

        //then
        assertThat(result).isTrue();
        assertThat(values.size()).isEqualTo(1);
    }

    @Test
    public void removeFromIndexTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        String oldData = values.remove(0);

        //then
        assertThat(oldData).isEqualTo(first);
        assertThat(values.get(0)).isEqualTo(second);
        assertThat(values.size()).isEqualTo(1);
    }

    @Test
    public void clearTest() {
        //given
        SimpleArrayList values = new SimpleArrayList();
        String first = "first";
        String second = "second";
        values.add(first);
        values.add(second);

        //when
        values.clear();

        //then
        assertThat(values.isEmpty()).isTrue();
    }
}