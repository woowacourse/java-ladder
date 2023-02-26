package ladder.domain;

public class MockRandomBarGenerator implements RandomGenerator{


    @Override
    public Bar generate() {
        return Bar.CONNECTED;
    }

}
