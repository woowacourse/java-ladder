package techcourse.jcf.mission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {

    @Test
    public void addTest() {
        SimpleLinkedList myValues = new SimpleLinkedList();

        Assertions.assertThat(myValues.add("first")).isTrue();
        Assertions.assertThat(myValues.add("second")).isTrue();
    }

}
