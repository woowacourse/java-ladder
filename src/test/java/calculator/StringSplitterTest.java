package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {
    @Test
    void 기본_구분자_나누기() {
        String[] nums1 = StringSplitter.split("1,2,3,4");
        String[] nums2 = StringSplitter.split("1;2;3;4");
        String[] nums3 = StringSplitter.split("1;2;3,4");
        String[] expected = {"1", "2", "3", "4"};

        assertThat(nums1).isEqualTo(expected);
        assertThat(nums2).isEqualTo(expected);
        assertThat(nums3).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자_나누기() {
        String[] nums1 = StringSplitter.split("//;\n1;2;3");
        String[] expected = {"1", "2", "3"};

        assertThat(nums1).isEqualTo(expected);
    }
}
