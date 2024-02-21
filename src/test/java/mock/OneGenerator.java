package mock;

import domain.NumberGenerator;

public class OneGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return 1;
    }
}
