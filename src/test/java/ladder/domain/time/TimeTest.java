package ladder.domain.time;

import ladder.domain.ladder.Height;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeTest {

    @Nested
    @DisplayName("getter를 이용한 테스트 방법")
    class TestFieldByGetter {
        private static LocalTime before = LocalTime.now();

        @RepeatedTest(1000)
        @DisplayName("getter 메서드를 이용하여 테스트할 수 있다.")
        void getter() {
            Height height = new Height(1);
            assertThat(height.getValue()).isEqualTo(1);
        }

        @AfterAll
        static void afterAll() {
            LocalTime after = LocalTime.now();
            System.out.println("before = " + before);
            System.out.println("after = " + after);

            Duration duration = Duration.between(before, after);
            long difference = duration.toMillis();

            System.out.println("getter = " + difference);
        }
    }

    @Nested
    @DisplayName("extracting를 이용한 테스트 방법")
    class TestFieldByExtracting {
        private static LocalTime before = LocalTime.now();

        @RepeatedTest(1000)
        @DisplayName("extracting 메서드를 이용하여 테스트할 수 있다.")
        void extracting() {
            Height height = new Height(1);
            assertThat(height).extracting("height")
                    .isEqualTo(1);
        }

        @AfterAll
        static void afterAll() {
            LocalTime after = LocalTime.now();
            System.out.println("before = " + before);
            System.out.println("after = " + after);

            Duration duration = Duration.between(before, after);
            long difference = duration.toMillis();

            System.out.println("extracting = " + difference);
        }
    }

    @Nested
    @DisplayName("equals() and hashCode() 이용한 테스트 방법")
    class TestFieldByEqualsAndHashCode {
        private static LocalTime before = LocalTime.now();

        @RepeatedTest(1000)
        @DisplayName("EqualsAndHashCode 메서드를 이용하여 테스트할 수 있다.")
        void equalsAndHashCode() {
            Height height = new Height(1);
            assertThat(height).isEqualTo(new Height(1));
        }

        @AfterAll
        static void afterAll() {
            LocalTime after = LocalTime.now();
            System.out.println("before = " + before);
            System.out.println("after = " + after);

            Duration duration = Duration.between(before, after);
            long difference = duration.toMillis();

            System.out.println("equalsAndHashCode = " + difference);
        }
    }
}
