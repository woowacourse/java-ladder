package ladder.domain;

import ladder.domain.ladder.Bar;

public class MockRandomBarGenerator implements RandomGenerator{


    @Override
    public Bar generate() {
        return Bar.CONNECTED;
    }

}
