package ladder.domain;

import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void aaa() {
        Lines lines = new Lines(3, 4);
        lines.generate(new MockGenerator(true));
    }
}