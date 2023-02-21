package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class SimpleArrayListTest {

    @Test
    public void addTest() {
        String input = "first";

        SimpleArrayList myValues = new SimpleArrayList();
        myValues.add(input);

        Assertions.assertThat(myValues.add(input)).isTrue();

        System.out.println(myValues);
    }

    @Test
    public void addWithUnlimitedCapacityTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));

        SimpleArrayList myValues = new SimpleArrayList();
        for (String value : values) {
            Assertions.assertThat(myValues.add(value)).isTrue();
        }

        System.out.println(myValues);
    }

    @Test
    public void addWithIndexTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        SimpleArrayList myValues = new SimpleArrayList();
        for (String value : values) {
            Assertions.assertThat(myValues.add(value)).isTrue();
        }

        String newValue = "함정카드";
        String oldValue = myValues.get(5);

        myValues.add(5, newValue);

        assertThat(myValues.size()).isEqualTo(12);
        assertThat(myValues.get(5)).isEqualTo(newValue);
        assertThat(myValues.get(6)).isEqualTo(oldValue);

        Assertions.assertThatThrownBy(() -> myValues.add(13, "이건 못넣지"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void getTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        SimpleArrayList myValues = new SimpleArrayList();
        for (String value : values) {
            myValues.add(value);
        }

        assertThat(myValues.get(10)).isEqualTo("k");
    }

    @Test
    public void sizeTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        SimpleArrayList myValues = new SimpleArrayList();
        for (String value : values) {
            myValues.add(value);
        }

        assertThat(myValues.size()).isEqualTo(11);
    }

    @Test
    public void isEmptyTest() {
        SimpleArrayList myValues = new SimpleArrayList();
        assertThat(myValues.isEmpty()).isTrue();

        myValues.add("a");
        assertThat(myValues.isEmpty()).isFalse();
    }

    @Test
    public void clearTest() {
        List<String> values = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        SimpleArrayList myValues = new SimpleArrayList();
        for (String value : values) {
            myValues.add(value);
        }
        myValues.clear();

        assertThat(myValues.isEmpty()).isTrue();
        assertThat(myValues.size()).isEqualTo(0);
        Assertions.assertThatThrownBy(() -> myValues.get(0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void setTest() {
        SimpleArrayList myValues = new SimpleArrayList();

        Assertions.assertThatThrownBy(() -> myValues.set(0, "hi hi"))
                .isInstanceOf(IndexOutOfBoundsException.class);

        myValues.add("hi hi 2");
        assertThat(myValues.set(0, "hi hi 3")).isEqualTo("hi hi 2");
        assertThat(myValues.get(0)).isEqualTo("hi hi 3");
    }

    @Test
    public void indexOfTest() {
        SimpleArrayList myValues = new SimpleArrayList();

        myValues.add("first");
        myValues.add("first");
        myValues.add("third");

        assertThat(myValues.indexOf("first")).isEqualTo(0);
        assertThat(myValues.indexOf("이건없지롱")).isEqualTo(-1);
    }

    @Test
    public void containsTest() {
        String input = "hi hi";
        SimpleArrayList myValues = new SimpleArrayList();

        assertThat(myValues.contains(input)).isFalse();

        myValues.add(input);
        assertThat(myValues.contains(input)).isTrue();

    }

}
