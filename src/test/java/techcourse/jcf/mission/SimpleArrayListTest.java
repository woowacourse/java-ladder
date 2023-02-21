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

}
