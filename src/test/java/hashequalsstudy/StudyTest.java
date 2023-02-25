package hashequalsstudy;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.SoftAssertions.assertSoftly;


/*
Debug 모드로 실행해서 주소값과 함께 비교..!!
 */
public class StudyTest {

    @Test
    void ATest() {
        A a = new A("001", "pil");
        A a2 = new A("001", "pil");

        A anotherA = a;


        a.moveForward();

        assertSoftly(softly -> {
            softly.assertThat(a).isEqualTo(a2);
            softly.assertThat(a.getPosition()).isEqualTo(1);
            softly.assertThat(a2.getPosition()).isEqualTo(0);

            softly.assertThat(anotherA.getPosition()).isEqualTo(1);
        });
    }

    @Test
    void BTest() {
        B b = new B("001", "pil");
        B b2 = new B("001", "pil");

        B anotherB = b;

        b.moveForward();

        assertSoftly(softly -> {
            softly.assertThat(b).isNotEqualTo(b2);
            softly.assertThat(b.getPosition()).isEqualTo(1);
            softly.assertThat(b2.getPosition()).isEqualTo(0);

            softly.assertThat(anotherB.getPosition()).isEqualTo(1);
        });
    }


    class A {
        private final String id;
        private final String name;
        private int position;

        A(String id, String name) {
            this.id = id;
            this.name = name;
            this.position = 0;
        }

        void moveForward() {
            position++;
        }

        int getPosition() {
            return position;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return Objects.equals(id, a.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    class B {
        private final String id;
        private final String name;
        private int position;

        B(String id, String name) {
            this.id = id;
            this.name = name;
            this.position = 0;
        }

        void moveForward() {
            position++;
        }

        int getPosition() {
            return position;
        }
    }

}
