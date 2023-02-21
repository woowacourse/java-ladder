package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class SimpleArrayListTest {

    @Test
    public void addTest() {
        String input = "first";

        SimpleArrayList myValues = new SimpleArrayList();
        myValues.add(input);

        Assertions.assertThat(myValues.add(input)).isTrue();
    }

}
